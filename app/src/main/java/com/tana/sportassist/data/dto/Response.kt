package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("league")
    val league: League
)