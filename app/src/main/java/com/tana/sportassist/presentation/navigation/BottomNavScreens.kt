package com.tana.sportassist.presentation.navigation

import com.tana.sportassist.R

sealed class BottomNavScreens(val route: String, val name: String, val icon: Int) {
    object Home : BottomNavScreens(route = "home", name = "Home", icon = R.drawable.home_outline_icon)
    object Matches : BottomNavScreens(route = "matches", name = "Matches", icon = R.drawable.football_icon)
    object Settings : BottomNavScreens(route = "settings", name = "Settings", icon = R.drawable.setting_icon)
}
