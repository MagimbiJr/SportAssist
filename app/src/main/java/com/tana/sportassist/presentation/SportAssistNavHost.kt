package com.tana.sportassist.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tana.sportassist.R

@Composable
fun SportAssistNavHost(
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = stringResource(id = R.string.home_route)) {
        composable(route = "home") {

        }
    }
}