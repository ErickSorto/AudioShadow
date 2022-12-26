package com.ballistic.audioshadow.domain.repository

import com.ballistic.audioshadow.domain.model.AudioRecording

interface AudioRecordingDataSource {
    fun saveAudioRecording(audioRecording: AudioRecording)
    fun getAudioRecordings(): List<AudioRecording>
    fun deleteAudioRecording(audioRecording: AudioRecording)
}