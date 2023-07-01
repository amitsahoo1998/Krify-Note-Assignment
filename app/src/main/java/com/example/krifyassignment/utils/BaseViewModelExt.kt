package com.example.krifyassignment.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.krifyassignment.presenter.view.state.State
import com.example.krifyassignment.presenter.view.viewmodels.BaseViewModel

@Composable
fun <S : State, VM : BaseViewModel<S>> VM.collectState() = state.collectAsStateWithLifecycle()