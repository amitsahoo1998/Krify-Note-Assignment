package com.example.krifyassignment.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.krifyassignment.presenter.component.scaffold.NotyScaffold
import com.example.krifyassignment.presenter.component.text.NoteField
import com.example.krifyassignment.presenter.component.text.NoteTitleField
import com.example.krifyassignment.presenter.view.viewmodels.NoteDetailViewModel
import com.example.krifyassignment.utils.collectState

@Composable
fun NoteDetailsScreen(
    viewModel: NoteDetailViewModel,
    onNavigateUp: () -> Unit
) {
    val state by viewModel.collectState()

    NoteDetailContent(
        title = state.title ?: "",
        note = state.note ?: "",
        onTitleChange = viewModel::setTitle,
        onNoteChange = viewModel::setNote,
        onSaveClick = viewModel::save,
        onDeleteClick = viewModel::delete,
        onNavigateUp = onNavigateUp
    )


    LaunchedEffect(state.finished) {
        if (state.finished) {
            onNavigateUp()
        }
    }
}

@Composable
fun NoteDetailContent(
    title: String,
    note: String,
    onTitleChange: (String) -> Unit,
    onNoteChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onNavigateUp: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    NotyScaffold(
        modifier = Modifier
            .focusRequester(focusRequester)
            .focusable(true),
        notyTopAppBar = {

        },
        content = {
            NoteDetailBody(
                title = title,
                onTitleChange = onTitleChange,
                note = note,
                onNoteChange = onNoteChange,
                onDeleteClick = onDeleteClick
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Save", color = Color.White) },
                icon = { Icon(Icons.Filled.Done, "Save", tint = Color.White) },
                onClick = onSaveClick,
                containerColor = MaterialTheme.colorScheme.primary
            )
        }
    )
}


@Composable
private fun NoteDetailBody(
    title: String,
    onTitleChange: (String) -> Unit,
    note: String,
    onNoteChange: (String) -> Unit,
    onDeleteClick: () -> Unit
) {
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
                .wrapContentHeight()
                .padding(top = 32.dp)
                .background(MaterialTheme.colorScheme.background),
            value = note,
            onTextChange = onNoteChange
        )
        IconButton(onClick = onDeleteClick) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Icon")
        }
    }
}

