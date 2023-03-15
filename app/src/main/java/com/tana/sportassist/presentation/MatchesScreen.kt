package com.tana.sportassist.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.tana.sportassist.presentation.tabs.SportAssistTabContent
import com.tana.sportassist.presentation.tabs.SportsAssistTabs
import com.tana.sportassist.presentation.tabs.TabsScreens
import com.tana.sportassist.utils.SportAssistEvents
import kotlinx.coroutines.CoroutineScope

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun MatchesScreen(
    navigateToFixture: (SportAssistEvents.Navigate) -> Unit,
    coroutineScope: CoroutineScope
) {
    val pagerState = rememberPagerState()
    val tabs = listOf(
        TabsScreens.LiveScore(),
        TabsScreens.Table,
        TabsScreens.Matches(
            navigateToFixture = navigateToFixture
        )
    )

    Column {
        SportsAssistTabs(pagerState = pagerState, coroutineScope = coroutineScope, screens = tabs)
        SportAssistTabContent(pagerState = pagerState, tabs = tabs)
    }
}