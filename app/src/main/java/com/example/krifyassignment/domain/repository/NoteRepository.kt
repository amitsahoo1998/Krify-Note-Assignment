package com.example.krifyassignment.domain.repository

import com.example.krifyassignment.data.local.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface NoteRepository {

    fun getAllNotes(): Flow<List<NoteEntity>>

    fun getNotes (noteId: Int) : Flow<NoteEntity>

    suspend fun addNote(title: String, note: String)

    suspend fun updateNote(
        noteId: Int,
        title: String,
        note: String
    )

    suspend fun deleteNote(noteId: Int)
}