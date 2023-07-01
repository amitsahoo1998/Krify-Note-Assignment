package com.example.krifyassignment.presenter.di

import com.example.krifyassignment.data.local.NoteDao
import com.example.krifyassignment.data.repository.NoteRepositoryImpl
import com.example.krifyassignment.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Qualifier

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}
