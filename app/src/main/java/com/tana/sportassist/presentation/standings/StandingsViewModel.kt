package com.tana.sportassist.presentation.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.sportassist.data.dto.toStanding
import com.tana.sportassist.domain.modal.Standing
import com.tana.sportassist.domain.use_cases.GetStandingsUseCase
import com.tana.sportassist.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class StandingsViewModel(
    private val standingsUseCase: GetStandingsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(StandingsScreenUiState())
    val uiState = _uiState.asStateFlow()
    private var standings: List<Standing> = emptyList()

    init {
        viewModelScope.launch {
            standingsUseCase(season = 2022, leagueId = 39).collectLatest { response ->
                when(response) {
                    is Resource.Success -> {
                        val data = response.data?.response?.forEach {
                            it.league.standings.map { standingDtos ->
                                standings = standingDtos.map { it.toStanding() }
                            }
                        }
                        _uiState.value = _uiState.value.copy(
                            standings = standings
                        )
                    }
                    is Resource.Failure -> {}
                    is Resource.Loading -> {}
                }
            }
        }
    }
}