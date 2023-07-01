package com.example.krifyassignment.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.krifyassignment.presenter.component.scaffold.NotyScaffold
import com.example.krifyassignment.presenter.component.text.NoteField
import com.example.krifyassignment.presenter.component.text.NoteTitleField
import com.example.krifyassignment.presenter.view.viewmodels.AddNoteViewModel
import com.example.krifyassignment.utils.collectState

@Composable
fun AddNoteScreen(
    viewModel: AddNoteViewModel,
    onNavigateUp : () -> Unit
) {
    val state by viewModel.collectState()

    AddNotesContent(
        title = state.title,
        note = state.note,
        onTitleChange = viewModel::setTitle,
        onNoteChange = viewModel::setNote,
        onClickAddNote = viewModel::add,
    )

    LaunchedEffect(state.added) {
        if (state.added) {
            onNavigateUp()
        }
    }
}

@Composable
fun AddNotesContent(
    title: String,
    note: String,
    onTitleChange: (String) -> Unit,
    onNoteChange: (String) -> Unit,
    onClickAddNote: () -> Unit,
) {
    NotyScaffold(
        notyTopAppBar = { },
        content = {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                NoteTitleField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background),
                    value = title,
                    onTextChange = onTitleChange
                )

                NoteField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 32.dp)
                        .background(MaterialTheme.colorScheme.background),
                    value = note,
                    onTextChange = onNoteChange
                )
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Save", color = Color.White) },
                icon = {
                    Icon(
                        Icons.Filled.Done,
                        "Save",
                        tint = Color.White
                    )
                },
                onClick = onClickAddNote,
                contentColor = MaterialTheme.colorScheme.primary
            )

        }
    )
}
