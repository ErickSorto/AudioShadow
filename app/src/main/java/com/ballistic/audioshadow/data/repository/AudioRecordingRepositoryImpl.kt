package com.ballistic.audioshadow.data.repository

import com.ballistic.audioshadow.data.data_source.AudioRecordingDao
import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import javax.inject.Inject

class AudioRecordingRepositoryImpl @Inject constructor(
    private val dao: AudioRecordingDao
) : AudioRecordingRepository {

    override suspend fun saveAudioRecording(audioRecording: AudioRecording) {
        if (audioRecording.id == "0") {
            // Insert a new audio recording if the ID is not set
            dao.insert(audioRecording)
        } else {
            // Update an existing audio recording if the ID is set
            dao.update(audioRecording)
        }
    }

    override fun getAudioRecordings(): List<AudioRecording> {
        return dao.getAll()
    }

    override suspend fun deleteAudioRecording(audioRecording: AudioRecording) {
        dao.delete(audioRecording)
    }

    override suspend fun getAudioRecording(id: String): AudioRecording {
        return dao.getById(id)
    }
}

