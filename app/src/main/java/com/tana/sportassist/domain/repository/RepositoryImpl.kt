package com.tana.sportassist.domain.repository

import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.data.remote.SportAssistApi
import com.tana.sportassist.data.repository.Repository

class RepositoryImpl(
    private val api: SportAssistApi
) : Repository {
    override suspend fun getStandings(season: Int, leagueId: Int): TableDto {
        return api.getStandings(season = season, leagueId = leagueId)
    }
}