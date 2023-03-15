package com.tana.sportassist.domain.repository

import android.util.Log
import com.tana.sportassist.data.dto.ResponseDto
import com.tana.sportassist.data.dto.StandingDto
import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.data.dto.fixture.FixtureResultDto
import com.tana.sportassist.data.remote.SportAssistApi
import com.tana.sportassist.data.repository.Repository
import com.tana.sportassist.domain.modal.Response

/**
 * The actual implementation of Repository.
 */
class RepositoryImpl(
    private val api: SportAssistApi
) : Repository {

    /**
     * Actual implementation on how to get standings data from api
     * This know from which api we are getting the data
     *[Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's standings
     */
    override suspend fun getStandings(season: Int, leagueId: Int): TableDto {
        return api.getStandings(season = season, leagueId = leagueId)
    }

    /**
     * Actual implementation on how to get fixture data from api
     * This know from which api we are getting the data
     *[Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's standings
     */
    override suspend fun getFixture(season: Int, leagueId: Int): FixtureResultDto {
        return api.getFixture(season = season, leagueId = leagueId)
    }

}