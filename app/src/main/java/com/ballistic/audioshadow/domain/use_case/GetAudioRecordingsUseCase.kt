package com.ballistic.audioshadow.domain.use_case

import com.ballistic.audioshadow.core.Resource
import com.ballistic.audioshadow.domain.model.AudioRecording
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import javax.inject.Inject

class GetAudioRecordingsUseCase @Inject constructor(
    private val audioRecordingRepository: AudioRecordingRepository
) {
    suspend operator fun invoke(): Resource<List<AudioRecording>> {
        return audioRecordingRepository.getAudioRecordings()
    }
}
