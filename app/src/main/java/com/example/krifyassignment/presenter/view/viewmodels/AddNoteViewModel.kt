package com.example.krifyassignment.presenter.view.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.krifyassignment.domain.repository.NoteRepository
import com.example.krifyassignment.presenter.view.state.AddNoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : BaseViewModel<AddNoteState>(initialState = AddNoteState()) {

    fun setTitle(title: String) {
        setState { state ->
            state.copy(
                title = title
            )
        }
    }

    fun setNote(note: String) {
        setState { state ->
            state.copy(note = note)
        }
    }

    fun add() {
        viewModelScope.launch {
            val title = state.value.title.trim()
            val note = state.value.note.trim()
            noteRepository.addNote(title, note)
            setState { state->
                state.copy(added = true)
            }
        }
    }
}