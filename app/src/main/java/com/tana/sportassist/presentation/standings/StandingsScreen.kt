package com.tana.sportassist.presentation.standings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tana.sportassist.domain.modal.Standing
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

