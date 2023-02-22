package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.Response

data class ResponseDto(
    @SerializedName("league")
    val league: League
)

