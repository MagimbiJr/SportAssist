package com.tana.sportassist.domain.modal

import com.tana.sportassist.data.dto.fixture.FixtureResponse

data class FixtureResult(
    val errors: List<Any>,
    val response: List<FixtureResponse>
)