package com.ballistic.audioshadow.di

import android.app.Application
import androidx.room.Room
import com.ballistic.audioshadow.data.data_source.AudioRecordingDatabase
import com.ballistic.audioshadow.data.repository.AudioRecordingRepositoryImpl
import com.ballistic.audioshadow.domain.repository.AudioRecordingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAudioRecordingDatabase(
        app: Application
    ): AudioRecordingDatabase {
        return Room.databaseBuilder(
            app,
            AudioRecordingDatabase::class.java,
            AudioRecordingDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAudioRecordingRepository(
        db: AudioRecordingDatabase
    ): AudioRecordingRepository {
        return AudioRecordingRepositoryImpl(db.audioRecordingDao)
    }

}