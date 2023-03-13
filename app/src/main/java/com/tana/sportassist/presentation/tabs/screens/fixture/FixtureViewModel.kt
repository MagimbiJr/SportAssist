package com.tana.sportassist.presentation.tabs.screens.fixture

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.sportassist.data.dto.fixture.toFixture
import com.tana.sportassist.domain.modal.Fixture
import com.tana.sportassist.domain.use_cases.GetFixtureUseCase
import com.tana.sportassist.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val fixtureUseCase: GetFixtureUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FixtureUiState())
    val uiState = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            fixtureUseCase(season = 2022, leagueId = 39).collectLatest { response->
                when(response) {
                    is Resource.Success -> {
                        Log.d("TAG", "sayona: ${uiState.value.loading}")
                        val fixture = response.data?.response?.map { it.toFixture() }?.filter {
                            it.fixture.status.long != "Match Finished"
                                    && it.fixture.status.long != "Match Postponed"
                                    && it.fixture.status.long != "Second Half"
                                    && it.fixture.status.long != "First Half"
                        }?.sortedBy { it.fixture.date }
                        _uiState.value = _uiState.value.copy(
                            fixture = fixture ?: emptyList(),
                            loading = false
                        )
                    }
                    is Resource.Failure -> {
                        _uiState.value = _uiState.value.copy(
                            errorMessage = response.message ?: "",
                            loading = false
                        )
                    }
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(loading = true)
                    }
                }
            }
        }
    }

}