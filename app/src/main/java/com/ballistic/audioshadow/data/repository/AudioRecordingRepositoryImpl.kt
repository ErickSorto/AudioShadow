package com.ballistic.audioshadow.data.repository

import android.net.Uri
import com.ballistic.audioshadow.core.AudioRecordingNotFoundException
import com.ballistic.audioshadow.core.Resource
import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import com.google.android.gms.common.api.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.io.File



class AudioRecordingRepositoryImpl(
    private val storage: FirebaseStorage,
    private val db: FirebaseFirestore
) : AudioRecordingRepository {

    private val audioRecordingsCollection = getCollectionReferenceForAudioRecordings()

    override suspend fun saveAudioRecording(audioRecording: AudioRecording): Resource<Unit> {
        return try {
            val audioRecordingKey = audioRecordingsCollection.document().id
            audioRecordingsCollection.document(audioRecordingKey).set(audioRecording).await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("")
        }
    }

    override suspend fun getAudioRecording(id: String): Resource<AudioRecording> {
        return try {
            val audioRecording = audioRecordingsCollection.document(id).get().await().toObject(AudioRecording::class.java)
            if (audioRecording != null) {
                Resource.Success(audioRecording)
            } else {
                Resource.Error("Audio recording not found")
            }
        } catch (e: Exception) {
            Resource.Error("")
        }
    }


    override suspend fun getAudioRecordings(): Resource<List<AudioRecording>> {
        return try {
            val audioRecordings = audioRecordingsCollection.get().await().toObjects(AudioRecording::class.java)
            Resource.Success(audioRecordings)
        } catch (e: Exception) {
            Resource.Error("")
        }
    }

    override suspend fun deleteAudioRecording(audioRecording: AudioRecording): Resource<Unit> {
        return try {
            audioRecordingsCollection.document(audioRecording.id).delete().await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("")
        }
    }

    private fun getCollectionReferenceForAudioRecordings(): CollectionReference {
        val currentUser = FirebaseAuth.getInstance().currentUser
        return db.collection("audio_recordings").document(currentUser!!.uid).collection("my_recordings")
    }
}
