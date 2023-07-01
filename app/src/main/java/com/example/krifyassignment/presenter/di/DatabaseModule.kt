package com.example.krifyassignment.presenter.di

import android.app.Application
import com.example.krifyassignment.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = NoteDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideCarDao(database: NoteDatabase) = database.getNotesDao()
}