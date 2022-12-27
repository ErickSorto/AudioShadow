package com.ballistic.audioshadow.data.data_source

import androidx.room.*
import com.ballistic.audioshadow.domain.model.AudioRecording

@Dao
interface AudioRecordingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(audioRecording: AudioRecording)

    @Update
    fun update(audioRecording: AudioRecording)

    @Delete
    fun delete(audioRecording: AudioRecording)

    @Query("SELECT * FROM audiorecording WHERE id = :id")
    fun getById(id: String): AudioRecording

    @Query("SELECT * FROM audiorecording")
    fun getAll(): List<AudioRecording>
}