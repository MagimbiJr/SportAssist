package com.tana.sportassist.domain.modal

import com.tana.sportassist.data.dto.fixture.FixtureDto
import com.tana.sportassist.data.dto.fixture.Goals
import com.tana.sportassist.data.dto.fixture.League
import com.tana.sportassist.data.dto.fixture.Score
import com.tana.sportassist.data.dto.fixture.Teams

data class Fixture(
    val fixture: FixtureModal,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)