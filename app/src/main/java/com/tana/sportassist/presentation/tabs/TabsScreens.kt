package com.tana.sportassist.presentation.tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tana.sportassist.presentation.tabs.screens.fixture.FixtureScreen
import com.tana.sportassist.presentation.tabs.screens.standings.StandingsScreen
import com.tana.sportassist.utils.SportAssistEvents

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

    @RequiresApi(Build.VERSION_CODES.O)
    class Matches(
        navigateToFixture: (SportAssistEvents.Navigate) -> Unit
    ) : TabsScreens(
        title = "Matches",
        screen = {
            FixtureScreen(
                navigateToFixture = navigateToFixture
            )
        }
    )
}
