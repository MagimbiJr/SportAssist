package com.tana.sportassist.domain.use_cases

import com.tana.sportassist.data.dto.fixture.toFixtureResult
import com.tana.sportassist.data.repository.Repository
import com.tana.sportassist.domain.modal.FixtureResult
import com.tana.sportassist.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * This use case handles only one use case of getting fixture from api
 * [Params]
 * [repository] A repository that knows how to get fixture from api
 */
class GetFixtureUseCase @Inject constructor(
    private val repository: Repository
) {
    /**
     * Invoke function that specifically get fixture from an api
     * [Params]
     * [season] A season year that you want get standings
     * [leagueId] An id of the league that you want to see it's fixture
     * */
    suspend operator fun invoke(season: Int, leagueId: Int): Flow<Resource<FixtureResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getFixture(season = season, leagueId = leagueId).toFixtureResult()
            emit(Resource.Success(data = result))
        } catch (e: HttpException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "An unknown error occurred"))
        }
    }

}