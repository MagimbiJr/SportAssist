package com.tana.sportassist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.tana.sportassist.presentation.tabs.SportAssistTabContent
import com.tana.sportassist.presentation.tabs.SportsAssistTabs
import com.tana.sportassist.presentation.tabs.TabsScreens
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MatchesScreen(
    coroutineScope: CoroutineScope
) {
    val pagerState = rememberPagerState()
    val tabs = listOf(
        TabsScreens.LiveScore(),
        TabsScreens.Table,
        TabsScreens.Matches()
    )

    Column {
        SportsAssistTabs(pagerState = pagerState, coroutineScope = coroutineScope, screens = tabs)
        SportAssistTabContent(pagerState = pagerState, tabs = tabs)
    }
}