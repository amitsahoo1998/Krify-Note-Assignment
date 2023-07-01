package com.example.krifyassignment.data.repository

import com.example.krifyassignment.data.local.NoteDao
import com.example.krifyassignment.data.local.NoteEntity
import com.example.krifyassignment.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override fun getAllNotes(): Flow<List<NoteEntity>> = noteDao.getAllNotes()

    override fun getNotes(noteId: Int): Flow<NoteEntity> =noteDao.getNote(noteId)

    override suspend fun addNote(title: String, note: String) = noteDao.addNote(NoteEntity(title = title, note = note))

    override suspend fun updateNote(noteId: Int, title: String, note: String) = noteDao.updateNoteById(noteId , title, note)

    override suspend fun deleteNote(noteId: Int) = noteDao.deleteNoteById(noteId)
}