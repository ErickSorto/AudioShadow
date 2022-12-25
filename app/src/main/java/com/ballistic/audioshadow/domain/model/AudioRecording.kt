package com.ballistic.audioshadow.domain.model

data class AudioRecording(
    val filePath: String,
    val duration: Long,
    val timestamp: Long
)