package com.tana.sportassist.data.remote

import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.data.dto.fixture.FixtureResultDto
import com.tana.sportassist.utils.SportAssistConstants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SportAssistApi {

    @GET("standings")
    @Headers("X-RapidAPI-Key: ${SportAssistConstants.API_KEY}")
    suspend fun getStandings(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): TableDto

    @GET("fixtures")
    @Headers("X-RapidAPI-Key: ${SportAssistConstants.API_KEY}")
    suspend fun getFixture(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): FixtureResultDto

}