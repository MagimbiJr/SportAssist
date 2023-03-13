package com.tana.sportassist.presentation.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tana.sportassist.presentation.tabs.screens.fixture.FixtureScreen
import com.tana.sportassist.presentation.tabs.screens.standings.StandingsScreen

sealed class TabsScreens(val title: String, val screen: @Composable () -> Unit) {
    class LiveScore : TabsScreens(
        title = "LiveScore",
        screen = {
            Text(text = "Live score")
        }
    )

    object Table : TabsScreens(
        title = "Table",
        screen = {
            StandingsScreen()
        }
    )

    class Matches : TabsScreens(
        title = "Matches",
        screen = {
            FixtureScreen()
        }
    )
}
