package com.example.krifyassignment.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    val title: String,
    val note: String,
)
