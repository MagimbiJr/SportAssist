package com.tana.sportassist.presentation.tabs.screens.fixture

import com.tana.sportassist.domain.modal.Fixture

data class FixtureUiState(
    val loading: Boolean = false,
    val fixture: List<Fixture> = emptyList(),
    val errorMessage: String = ""
)