package com.ballistic.audioshadow.domain.repository

import com.ballistic.audioshadow.core.Resource
import com.ballistic.audioshadow.domain.model.AudioRecording

interface AudioRecordingRepository {
    suspend fun saveAudioRecording(audioRecording: AudioRecording): Resource<Unit>
    suspend fun getAudioRecording(id: String): Resource<AudioRecording>
    suspend fun getAudioRecordings(): Resource<List<AudioRecording>>
    suspend fun deleteAudioRecording(audioRecording: AudioRecording): Resource<Unit>
}