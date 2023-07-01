package com.example.krifyassignment.presenter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.krifyassignment.data.local.NoteEntity
import com.example.krifyassignment.presenter.component.note.NotesList
import com.example.krifyassignment.presenter.component.scaffold.NotyScaffold
import com.example.krifyassignment.presenter.view.viewmodels.NoteViewModel
import com.example.krifyassignment.utils.collectState

@Composable
fun NoteScreen(
    viewModel: NoteViewModel,
    onAddNoteClick: () -> Unit,
    onNavigateToNoteDetail: (Int) -> Unit
) {
    val state by viewModel.collectState()

    NotesContent(
        notes = state.note,
        onAddNoteClick = onAddNoteClick,
        onNavigateToNoteDetail = onNavigateToNoteDetail
    )
}

@Composable
fun NotesContent(
    notes: List<NoteEntity>,
    onAddNoteClick: () -> Unit,
    onNavigateToNoteDetail: (Int) -> Unit
) {
    NotyScaffold(
        notyTopAppBar = {

        },
        content = {

            Column {
                NotesList(notes) { note ->
                    onNavigateToNoteDetail(note.noteId)
                }
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClick,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Add",
                    tint = Color.White
                )
            }
        }
    )

}
