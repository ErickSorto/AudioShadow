package com.ballistic.audioshadow.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ballistic.audioshadow.domain.model.AudioRecording

@Database(entities = [AudioRecording::class], version = 1)
abstract class AudioRecordingDatabase : RoomDatabase() {

    abstract val audioRecordingDao: AudioRecordingDao

    companion object {
        const val DATABASE_NAME = "audio_recording_database"
    }
}