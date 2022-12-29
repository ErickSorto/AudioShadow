package com.ballistic.audioshadow.domain.model


data class AudioRecording(
    val id: String,
    val title: String,
    val filePath: String,
    val duration: Long
)