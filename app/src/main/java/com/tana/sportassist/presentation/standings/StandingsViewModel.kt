package com.tana.sportassist.presentation.standings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.sportassist.data.dto.toStanding
import com.tana.sportassist.domain.modal.Standing
import com.tana.sportassist.domain.use_cases.GetStandingsUseCase
import com.tana.sportassist.utils.Resource
import com.tana.sportassist.utils.SportAssistConstants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val standingsUseCase: GetStandingsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(StandingsScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            standingsUseCase(season = 2022, leagueId = 39).collectLatest { response ->
                when (response) {
                    is Resource.Success -> {
                        var standings: List<Standing> = emptyList()
                        response.data?.response?.forEach { result ->
                            result.league.standings.forEach { standingDtos ->
                                standings = standingDtos.map { it.toStanding() }
                            }
                        }

                        _uiState.value = _uiState.value.copy(
                            standings = standings,
                            loading = false
                        )
                        Log.d(TAG, "initBlock: standings $standings")
                    }
                    is Resource.Failure -> {
                        _uiState.value = _uiState.value.copy(
                            errorMessage = response.message ?: "",
                            loading = false
                        )
                        Log.d(TAG, "initBlock: message ${response.message}")
                    }
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            loading = true
                        )
                        Log.d(TAG, "initBlock: loading ${_uiState.value.loading}")
                    }
                }
            }
        }
    }
}