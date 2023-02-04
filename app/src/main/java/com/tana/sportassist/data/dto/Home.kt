package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int
)