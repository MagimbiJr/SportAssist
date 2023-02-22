package com.tana.sportassist.domain.use_cases

import android.util.Log
import com.tana.sportassist.data.dto.TableDto
import com.tana.sportassist.data.dto.toTable
import com.tana.sportassist.data.remote.SportAssistApi
import com.tana.sportassist.data.repository.Repository
import com.tana.sportassist.domain.modal.Standing
import com.tana.sportassist.domain.modal.Table
import com.tana.sportassist.utils.Resource
import com.tana.sportassist.utils.SportAssistConstants.TAG
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

/**
 * A use case that handle only one use case of getting standings from api
 * [Params]
 * [repository] A repository that knows how to get standings from api
*/
class GetStandingsUseCase(
    private val repository: Repository,
) {
    /**
     * Invoke function that specifically get standings from an api
     * [Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's standings
     * */

    suspend operator fun invoke(season: Int, leagueId: Int): Flow<Resource<Table>> = flow {
        try {
            emit(Resource.Loading())
            repository.getStandings(season = season, leagueId = leagueId)
            val data = repository.getStandings(season = season, leagueId = leagueId).toTable()
            emit(Resource.Success(data = data))
        } catch (exception: Exception) {
            Log.d( TAG, "invokeBlock: This is exception block")
            emit(Resource.Failure(message = exception.localizedMessage ?: "An unknown HTTP error occurred"))
        } catch (exception: IOException) {
            Log.d( TAG, "invokeBlock: This is io exception block")
            emit(Resource.Failure(message = exception.localizedMessage ?: "An unknown IO error occurred"))
        }
    }
}