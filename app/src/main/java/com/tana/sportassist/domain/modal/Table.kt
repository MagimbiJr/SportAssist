package com.tana.sportassist.domain.modal

import com.tana.sportassist.data.dto.ResponseDto

data class Table(
    val errors: List<String>,
    val response: List<ResponseDto>
)