package com.ballistic.audioshadow.domain.repository

import com.ballistic.audioshadow.domain.model.AudioRecording

interface AudioRecordingRepository {
    suspend fun saveAudioRecording(audioRecording: AudioRecording)
    fun getAudioRecordings(): List<AudioRecording>
    suspend fun getAudioRecording(id: String): AudioRecording
    suspend fun deleteAudioRecording(audioRecording: AudioRecording)
}