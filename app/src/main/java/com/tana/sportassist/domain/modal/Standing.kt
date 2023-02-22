package com.tana.sportassist.domain.modal

import com.tana.sportassist.data.dto.All
import com.tana.sportassist.data.dto.Team

data class Standing(
    val all: All,
    val description: String?,
    val goalsDiff: Int,
    val points: Int,
    val rank: Int,
    val team: Team,
    val update: String
)
