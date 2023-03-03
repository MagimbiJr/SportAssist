package com.tana.sportassist.data.dto.fixture


import com.google.gson.annotations.SerializedName

data class FixtureDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("periods")
    val periods: Periods,
    @SerializedName("referee")
    val referee: String?,
    @SerializedName("status")
    val status: Status,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Venue
)