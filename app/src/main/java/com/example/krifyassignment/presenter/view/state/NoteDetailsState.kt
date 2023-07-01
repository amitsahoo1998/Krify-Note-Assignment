package com.example.krifyassignment.presenter.view.state

data class NoteDetailsState(
    val title: String? = null,
    val note: String? = null,
    val finished: Boolean = false
) : State
