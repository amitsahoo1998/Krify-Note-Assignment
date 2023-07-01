package com.example.krifyassignment.presenter.component.note

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.krifyassignment.data.local.NoteEntity

@Composable
fun NotesList(notes: List<NoteEntity>, onClick: (NoteEntity) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 4.dp),
        modifier = Modifier.testTag("notesList")
    ) {
        items(
            items = notes,
            itemContent = { note ->
                NoteCard(
                    title = note.title,
                    note = note.note,
                    onNoteClick = { onClick(note) }
                )
            },
            key = { Triple(it.noteId, it.title, it.note) }
        )
    }
}
