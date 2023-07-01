package com.example.krifyassignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE noteId = :noteId")
    fun getNote(noteId: Int) : Flow<NoteEntity>

    @Query("DELETE FROM notes WHERE noteId = :noteId")
    suspend fun deleteNoteById(noteId: Int)

    @Query("UPDATE notes SET title = :title, note = :note WHERE noteId = :noteId")
    suspend fun updateNoteById(noteId: Int, title: String, note: String)

}