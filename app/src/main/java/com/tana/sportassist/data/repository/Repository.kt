package com.tana.sportassist.data.repository

import com.tana.sportassist.data.dto.TableDto

interface Repository {

    suspend fun getStandings(season: Int, leagueId: Int): TableDto

}