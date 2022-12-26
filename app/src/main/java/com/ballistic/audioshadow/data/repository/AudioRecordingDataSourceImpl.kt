package com.ballistic.audioshadow.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingDataSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AudioRecordingDataSourceImpl(private val database: FirebaseDatabase) :
    AudioRecordingDataSource {
    private val audioRecordingsReference = database.getReference("audioRecordings")

    override fun saveAudioRecording(audioRecording: AudioRecording) {
        val audioRecordingKey = audioRecordingsReference.push().key
        if (audioRecordingKey != null) {
            audioRecordingsReference.child(audioRecordingKey).setValue(audioRecording)
        }
    }

    override fun getAudioRecordings(): List<AudioRecording> {
        val audioRecordings = mutableListOf<AudioRecording>()
        audioRecordingsReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (audioRecordingSnapshot in dataSnapshot.children) {
                    val audioRecording = audioRecordingSnapshot.getValue(AudioRecording::class.java)
                    if (audioRecording != null) {
                        audioRecordings.add(audioRecording)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Failed to read audio recordings", error.toException())
            }
        })
        return audioRecordings
    }

    override fun deleteAudioRecording(audioRecording: AudioRecording) {
        TODO("Not yet implemented")
    }
}