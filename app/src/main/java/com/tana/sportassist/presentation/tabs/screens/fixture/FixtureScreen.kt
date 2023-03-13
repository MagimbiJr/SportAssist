package com.tana.sportassist.presentation.tabs.screens.fixture

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.sportassist.presentation.components.LoadingBody

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FixtureScreen(
    modifier: Modifier = Modifier,
    viewModel: FixtureViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    
    if (uiState.loading) {
        LoadingBody(modifier = modifier)
    } else {
        Scaffold { paddingValue ->
            FixtureContent(uiState = uiState, modifier = modifier.padding(paddingValue))
        }
    }
}