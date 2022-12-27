package com.ballistic.audioshadow.domain.use_case

import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import javax.inject.Inject

class GetAudioRecordingsUseCase @Inject constructor(
    private val audioRecordingRepository: AudioRecordingRepository
) {
    suspend operator fun invoke(): List<AudioRecording> {
        return audioRecordingRepository.getAudioRecordings()
    }
}
