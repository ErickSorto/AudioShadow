package com.ballistic.audioshadow.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AudioRecording(
    @PrimaryKey val id: String,
    val title: String,
    val filePath: String,
    val duration: Long
)