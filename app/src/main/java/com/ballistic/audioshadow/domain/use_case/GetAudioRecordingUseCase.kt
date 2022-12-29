package com.ballistic.audioshadow.domain.use_case

import com.ballistic.audioshadow.core.AudioRecordingNotFoundException
import com.ballistic.audioshadow.core.Resource
import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import javax.inject.Inject

class GetAudioRecordingUseCase @Inject constructor(
    private val audioRecordingRepository: AudioRecordingRepository
) {
    suspend operator fun invoke(id: String): Resource<AudioRecording> {
        return audioRecordingRepository.getAudioRecording(id)
    }
}
