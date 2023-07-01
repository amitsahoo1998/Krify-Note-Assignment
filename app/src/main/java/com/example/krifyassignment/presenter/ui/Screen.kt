package com.example.krifyassignment.presenter.ui

sealed class Screen(val route: String , val name : String){
    object Note : Screen("note" , "NoteScreen")

    object AddNote : Screen("add_note" ,"AddNoteScreen")

    object NotesDetail : Screen("note/{noteId}", "Note details") {
        fun route(noteId: Int) = "note/$noteId"

        const val ARG_NOTE_ID: String = "noteId"
    }
}
