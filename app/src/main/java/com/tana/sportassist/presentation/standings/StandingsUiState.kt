package com.tana.sportassist.presentation.standings

import com.tana.sportassist.domain.modal.Standing

data class StandingsScreenUiState(
    val loading: Boolean = false,
    val standings: List<Standing> = emptyList(),
    val errorMessage: String = "",
)
