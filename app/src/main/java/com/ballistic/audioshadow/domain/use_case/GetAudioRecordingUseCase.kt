package com.ballistic.audioshadow.domain.use_case

import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import javax.inject.Inject

class GetAudioRecordingUseCase @Inject constructor(
    private val audioRecordingRepository: AudioRecordingRepository
) {
    suspend operator fun invoke(id: String): AudioRecording {
        return audioRecordingRepository.getAudioRecording(id)
    }
}
