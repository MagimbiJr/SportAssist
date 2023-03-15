package com.tana.sportassist.data.dto.fixture


import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.FixtureResult

data class FixtureResultDto(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<FixtureResponse>,
    @SerializedName("results")
    val results: Int
)


fun FixtureResultDto.toFixtureResult(): FixtureResult {
    return FixtureResult(
        errors = errors,
        response = response
    )
}