package com.tana.sportassist.domain.use_cases

import com.tana.sportassist.data.dto.toTable
import com.tana.sportassist.data.repository.Repository
import com.tana.sportassist.domain.modal.Table
import com.tana.sportassist.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

/**
 * A use case that handle only one use case of getting standings from api
 * [Params]
 * [repository] A repository that knows how to get standings from api
*/
class GetStandingsUseCase(
    private val repository: Repository
) {
    /**
     * Invoke function that specifically get standings from api
     * [Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's standings
     * */

    suspend operator fun invoke(season: Int, leagueId: Int): Flow<Resource<Table>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getStandings(season = season, leagueId = leagueId).toTable()
            emit(Resource.Success(data = data))
        } catch (exception: Exception) {
            emit(Resource.Failure(message = exception.localizedMessage ?: "An unknown HTTP error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Failure(message = exception.localizedMessage ?: "An unknown IO error occurred"))
        }
    }
}