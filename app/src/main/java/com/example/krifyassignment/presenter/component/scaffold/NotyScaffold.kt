package com.example.krifyassignment.presenter.component.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Compose's wrapped Scaffold for this project
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotyScaffold(
    modifier: Modifier = Modifier,
    notyTopAppBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = notyTopAppBar,
        content = content,
        floatingActionButton = floatingActionButton
    )
}
