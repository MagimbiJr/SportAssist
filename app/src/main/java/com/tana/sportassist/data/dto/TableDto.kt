package com.tana.sportassist.data.dto


import com.google.gson.annotations.SerializedName
import com.tana.sportassist.domain.modal.Table

data class TableDto(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("results")
    val results: Int
)

fun TableDto.toTable(): Table =
    Table(response = response)