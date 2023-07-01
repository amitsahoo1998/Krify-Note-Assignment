package com.example.krifyassignment.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.krifyassignment.presenter.screens.AddNoteScreen
import com.example.krifyassignment.presenter.screens.NoteDetailsScreen
import com.example.krifyassignment.presenter.screens.NoteScreen
import com.example.krifyassignment.presenter.ui.Screen
import com.example.krifyassignment.presenter.view.viewmodels.NoteDetailViewModel
import com.example.krifyassignment.utils.assistedViewModel

const val NOTE_NAV_HOST_ROUTE = "app-main-route"

@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Note.route, route = NOTE_NAV_HOST_ROUTE) {

        composable(Screen.Note.route) {
            NoteScreen(
                viewModel = hiltViewModel(),
                onAddNoteClick = { navController.navigateToAddNote() },
                onNavigateToNoteDetail = {noteId ->
                    navController.navigateToNoteDetail(noteId)
                })
        }

        composable(Screen.AddNote.route) {
            AddNoteScreen(viewModel = hiltViewModel(),
                onNavigateUp = { navController.navigateUp() })
        }


        composable(
            Screen.NotesDetail.route,
            arguments = listOf(
                navArgument(Screen.NotesDetail.ARG_NOTE_ID) { type = NavType.IntType }
            )
        ) {
            val noteId = requireNotNull(it.arguments?.getInt(Screen.NotesDetail.ARG_NOTE_ID))
            NoteDetailsScreen(
                viewModel = assistedViewModel {
                    NoteDetailViewModel.provideFactory(noteDetailViewModelFactory(), noteId)
                },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

fun NavController.navigateToAddNote() = navigate(Screen.AddNote.route)

fun NavController.navigateToNoteDetail(noteId: Int) = navigate(Screen.NotesDetail.route(noteId))