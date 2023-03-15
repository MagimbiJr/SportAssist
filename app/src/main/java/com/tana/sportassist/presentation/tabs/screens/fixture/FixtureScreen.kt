package com.tana.sportassist.presentation.tabs.screens.fixture

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.sportassist.presentation.components.LoadingBody
import com.tana.sportassist.utils.SportAssistEvents
import kotlinx.coroutines.flow.collectLatest

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FixtureScreen(
    navigateToFixture: (SportAssistEvents.Navigate) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FixtureViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    val appEvents = viewModel.appEvent

    LaunchedEffect(key1 = appEvents) {
        appEvents.collectLatest { event ->
            when(event) {
                is SportAssistEvents.Navigate -> {
                    navigateToFixture(event)
                }
                is SportAssistEvents.PopBackStack -> Unit
            }
        }
    }
    
    if (uiState.loading) {
        LoadingBody(modifier = modifier)
    } else {
        Scaffold { paddingValue ->
            FixtureContent(
                uiState = uiState,
                onMatchClick = viewModel::onMatchClicked,
                modifier = modifier.padding(paddingValue),
            )
        }
    }
}