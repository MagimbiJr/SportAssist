package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("against")
    val against: Int,
    @SerializedName("for")
    val forX: Int
)