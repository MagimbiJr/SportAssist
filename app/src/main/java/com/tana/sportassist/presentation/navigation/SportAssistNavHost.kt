package com.tana.sportassist.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tana.sportassist.R
import com.tana.sportassist.presentation.MatchesScreen
import com.tana.sportassist.presentation.components.SportAssistBottomNav
import com.tana.sportassist.utils.SportAssistConstants
import kotlinx.coroutines.CoroutineScope

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun SportAssistNavHost(
    navHostController: NavHostController,
    coroutineScope: CoroutineScope,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            SportAssistBottomNav(navHostController = navHostController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navHostController,
            startDestination = stringResource(id = R.string.home_route),
            modifier = modifier
                .padding(paddingValues = paddingValues)
        ) {

            composable(route = BottomNavScreens.Home.route) {

            }
            composable(route = BottomNavScreens.Matches.route) {
                MatchesScreen(
                    navigateToFixture = { navHostController.navigate(it.route) },
                    coroutineScope = coroutineScope
                )
            }
            composable(route = BottomNavScreens.Settings.route) {

            }
            composable("${SportAssistConstants.FIXTURE_ROUTE}/{fixtureId}") {

            }
        }
    }
}