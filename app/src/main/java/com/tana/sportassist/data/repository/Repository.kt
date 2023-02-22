package com.tana.sportassist.data.repository

import com.tana.sportassist.data.dto.ResponseDto
import com.tana.sportassist.data.dto.StandingDto
import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.domain.modal.Response


/**
 * A data layer that defines business logic for the entire application
 * This abstract so that the rest of application won't know the actual source of data,
 * hence the rest of application won't modify it
 */
interface Repository {

    /**
     * A function to get standings data
     *[Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's standings
     */
    suspend fun getStandings(season: Int, leagueId: Int): TableDto

}