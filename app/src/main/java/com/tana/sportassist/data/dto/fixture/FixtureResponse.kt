package com.tana.sportassist.data.dto.fixture


import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.Fixture

data class FixtureResponse(
    @SerializedName("fixture")
    val fixture: FixtureDto,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("league")
    val league: League,
    @SerializedName("score")
    val score: Score,
    @SerializedName("teams")
    val teams: Teams
)


fun FixtureResponse.toFixture(): Fixture {
    return Fixture(
        fixture = fixture,
        goals = goals,
        league = league,
        score = score,
        teams = teams
    )
}