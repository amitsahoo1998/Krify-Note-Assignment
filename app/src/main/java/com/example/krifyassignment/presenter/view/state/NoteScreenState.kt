package com.example.krifyassignment.presenter.view.state

import com.example.krifyassignment.data.local.NoteEntity

data class NoteScreenState(
    val note : List<NoteEntity> = emptyList()
) : State
