package com.tana.sportassist.data.dto.fixture


import android.os.Build
import androidx.annotation.RequiresApi
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


@RequiresApi(Build.VERSION_CODES.O)
fun FixtureResponse.toFixture(): Fixture {
    return Fixture(
        fixture = fixture.toFixtureModal(),
        goals = goals,
        league = league,
        score = score,
        teams = teams
    )
}