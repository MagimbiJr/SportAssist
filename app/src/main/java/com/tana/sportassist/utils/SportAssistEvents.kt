package com.tana.sportassist.utils

sealed class SportAssistEvents {
    data class Navigate(val route: String) : SportAssistEvents()
    object PopBackStack : SportAssistEvents()
}
