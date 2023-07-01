package com.example.krifyassignment.presenter.di

import com.example.krifyassignment.data.repository.NoteRepositoryImpl
import com.example.krifyassignment.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
interface LocalRepositoryModule {

    @Binds
    @LocalRepository
    fun notyLocalNoteRepository(localRepository: NoteRepositoryImpl): NoteRepository

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalRepository
