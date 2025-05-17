package com.rumosoft.material3expressive.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rumosoft.material3expressive.ui.theme.Material3ExpressiveTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3ExpressiveTheme {
                val navController = rememberNavController()
                var navigateToLoadings by rememberSaveable { mutableStateOf(false) }
                var navigateToSplitButton by rememberSaveable { mutableStateOf(false) }
                LaunchedEffect(navigateToLoadings) {
                    if (navigateToLoadings) {
                        navController.navigate(Route.LoadingIndicators)
                        navigateToLoadings = false
                    }
                }
                LaunchedEffect(navigateToSplitButton) {
                    if (navigateToSplitButton) {
                        navController.navigate(Route.SplitButtons)
                        navigateToSplitButton = false
                    }
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController, startDestination = Route.Home, Modifier.padding(innerPadding)) {
                        composable<Route.Home> {
                            HomeScreen(
                                onLoadingIndicatorSelected = { navigateToLoadings = true },
                                onSplitButtonSelected = { navigateToSplitButton = true }
                            )
                        }
                        composable<Route.LoadingIndicators> { LoadingIndicatorsScreen() }

                        composable<Route.SplitButtons> { FilledSplitButton() }
                    }
                }
            }
        }
    }
}

@Serializable
sealed class Route {
    @Serializable
    data object Home : Route()

    @Serializable
    data object LoadingIndicators : Route()

    @Serializable
    data object SplitButtons : Route()
}
