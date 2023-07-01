package com.example.krifyassignment.presenter.view.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.krifyassignment.domain.repository.NoteRepository
import com.example.krifyassignment.presenter.view.state.NoteScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : BaseViewModel<NoteScreenState>(initialState = NoteScreenState()) {
    init {
        observeNotes()
    }

    private fun observeNotes() {
        noteRepository.getAllNotes()
            .distinctUntilChanged()
            .onEach {
                setState { state ->
                    state.copy(
                        note = it
                    )
                }
            }.launchIn(viewModelScope)
    }
}