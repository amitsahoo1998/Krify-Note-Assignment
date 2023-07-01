package com.example.krifyassignment.presenter.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NoteTitleField(
    modifier: Modifier = Modifier,
    value: String = "",
    onTextChange: (String) -> Unit
) {
    BasicNotyTextField(
        modifier,
        value = value,
        label = "Title",
        onTextChange = onTextChange,
        textStyle = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
        maxLines = 2
    )
}

@Composable
fun NoteField(
    modifier: Modifier = Modifier,
    value: String = "",
    onTextChange: (String) -> Unit
) {
    BasicNotyTextField(
        modifier,
        value = value,
        label = "Write note here",
        onTextChange = onTextChange,
        textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Light)
    )
}
