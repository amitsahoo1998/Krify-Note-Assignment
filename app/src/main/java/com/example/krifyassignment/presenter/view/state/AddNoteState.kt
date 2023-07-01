package com.example.krifyassignment.presenter.view.state

data class AddNoteState(
    val title: String = "",
    val note: String = "",
    val added : Boolean = false
): State
