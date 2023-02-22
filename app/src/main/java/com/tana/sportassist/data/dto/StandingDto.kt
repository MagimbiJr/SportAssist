package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.Standing

data class StandingDto(
    @SerializedName("all")
    val all: All,
    @SerializedName("away")
    val away: Away,
    @SerializedName("description")
    val description: String,
    @SerializedName("form")
    val form: String,
    @SerializedName("goalsDiff")
    val goalsDiff: Int,
    @SerializedName("group")
    val group: String,
    @SerializedName("home")
    val home: Home,
    @SerializedName("points")
    val points: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("update")
    val update: String
)

fun StandingDto.toStanding() =
    Standing(
        all = all,
        description = description,
        goalsDiff = goalsDiff,
        points = points,
        rank = rank,
        team = team,
        update = update
    )