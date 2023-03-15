package com.tana.sportassist.data.dto.fixture


import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.FixtureModal
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

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
    val timestamp: Long,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Venue
)

@RequiresApi(Build.VERSION_CODES.O)
fun FixtureDto.toFixtureModal(): FixtureModal {
    val date = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp),
        ZoneId.systemDefault()
    ).toLocalDate()

    val time = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestamp),
        ZoneId.systemDefault()
    ).toLocalTime()
    return FixtureModal(
        fixtureId = id,
        date = date,
        time = time,
        periods = periods,
        referee = referee,
        status = status,
        venue = venue
    )
}