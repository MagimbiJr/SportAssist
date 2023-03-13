package com.tana.sportassist.domain.modal

import com.tana.sportassist.data.dto.fixture.Periods
import com.tana.sportassist.data.dto.fixture.Status
import com.tana.sportassist.data.dto.fixture.Venue
import java.time.LocalDate
import java.time.LocalTime

data class FixtureModal(
    val fixtureId: Int,
    val date: LocalDate,
    val time: LocalTime,
    val periods: Periods,
    val referee: String?,
    val status: Status,
    val venue: Venue
)
