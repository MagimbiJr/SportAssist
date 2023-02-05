package com.tana.sportassist.data.remote

import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.utils.SportAssistConstants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SportAssistApi {

    @GET("/standings?season&league_id")
    @Headers("X-RapidAPI-Key: ${SportAssistConstants.API_KEY}")
    suspend fun getStandings(
        @Query("season") season: Int,
        @Query("league_id") leagueId: Int
    ): TableDto

}