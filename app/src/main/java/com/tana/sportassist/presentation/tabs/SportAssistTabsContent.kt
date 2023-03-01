package com.tana.sportassist.presentation.tabs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SportAssistTabContent(
    pagerState: PagerState,
    tabs: List<TabsScreens>,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        count = tabs.size,
        state = pagerState,
        modifier = modifier
            .fillMaxSize()
    ) { page ->
        tabs[page].screen()
    }
}