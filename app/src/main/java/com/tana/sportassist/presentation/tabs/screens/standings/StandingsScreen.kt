package com.tana.sportassist.presentation.tabs.screens.standings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.sportassist.presentation.components.LoadingBody

@Composable
fun StandingsScreen(
    modifier: Modifier = Modifier,
    viewModel: StandingsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    if (uiState.loading) {
        LoadingBody(modifier = modifier)
    } else {
       StandingsContent(uiState = uiState, modifier = modifier)
    }
}

