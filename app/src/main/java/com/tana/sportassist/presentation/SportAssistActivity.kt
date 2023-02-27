package com.tana.sportassist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.tana.sportassist.presentation.navigation.SportAssistNavHost
import com.tana.sportassist.presentation.theme.SportAssistTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportAssistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            SportAssistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SportAssistNavHost(navHostController = navHostController, coroutineScope = coroutineScope)
                }
            }
        }
    }
}