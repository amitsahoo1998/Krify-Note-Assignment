package com.example.krifyassignment.presenter.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.krifyassignment.data.local.NoteEntity
import com.example.krifyassignment.domain.repository.NoteRepository
import com.example.krifyassignment.presenter.di.LocalRepository
import com.example.krifyassignment.presenter.view.state.NoteDetailsState
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class NoteDetailViewModel @AssistedInject constructor(
    @LocalRepository private val noteRepository: NoteRepository,
    @Assisted private val noteId: Int
) : BaseViewModel<NoteDetailsState>(initialState = NoteDetailsState()) {


    private lateinit var currentNote: NoteEntity

    init {
        loadNote()
    }

    fun setTitle(title: String) {
        setState { state ->
            state.copy(title = title)
        }
    }

    fun setNote(note: String) {
        setState { state ->
            state.copy(note = note)
        }
    }

    private fun loadNote() {
        viewModelScope.launch {
            val note = noteRepository.getNotes(noteId).firstOrNull()

            setState { state ->
                state.copy(note = note?.note , title = note?.title)
            }
        }
    }

    fun save() {
        val title = currentState.title?.trim() ?: return
        val note = currentState.note?.trim() ?: return

        viewModelScope.launch {
            noteRepository.updateNote(noteId, title, note)
            setState { state->
                state.copy(finished = true)
            }
        }
    }

    fun delete() {
        viewModelScope.launch {
            noteRepository.deleteNote(noteId)
            setState { state->
                state.copy(finished = true)
            }
        }
    }


    @AssistedFactory
    interface Factory {
        fun create(noteId: Int): NoteDetailViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            noteId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(noteId) as T
            }
        }
    }
}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule
