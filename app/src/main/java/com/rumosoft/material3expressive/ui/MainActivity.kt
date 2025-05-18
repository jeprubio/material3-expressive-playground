package com.rumosoft.material3expressive.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController, startDestination = Route.Home, Modifier.padding(innerPadding)) {
                        composable<Route.Home> {
                            HomeScreen(
                                onLoadingIndicatorSelected = { navController.navigate(Route.LoadingIndicators) },
                                onSplitButtonSelected = { navController.navigate(Route.SplitButtons) },
                                onFloatingActionButtonSelected = { navController.navigate(Route.FloatingActionButtonMenu) },
                                onButtonGroupSelected = { navController.navigate(Route.ButtonGroup) },
                                onVerticalFloatingToolbarSelected = { navController.navigate(Route.VerticalFloatingToolbar) },
                                onHorizontalFloatingToolbarSelected = { navController.navigate(Route.HorizontalFloatingToolbar) },
                                onFlexibleBottomAppBarSelected = { navController.navigate(Route.FlexibleBottomAppBar) },
                            )
                        }
                        composable<Route.LoadingIndicators> { LoadingIndicatorsScreen() }

                        composable<Route.SplitButtons> { SplitButtonsScreen() }

                        composable<Route.FloatingActionButtonMenu> { FloatingActionButtonMenuScreen() }

                        composable<Route.ButtonGroup> { ButtonGroupScreen() }

                        composable<Route.VerticalFloatingToolbar> { VerticalFloatingToolbarScreen() }

                        composable<Route.HorizontalFloatingToolbar> { HorizontalFloatingToolbarScreen() }

                        composable<Route.FlexibleBottomAppBar> { FlexibleBottomAppBarScreen() }
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

    @Serializable
    data object FloatingActionButtonMenu : Route()

    @Serializable
    data object ButtonGroup : Route()

    @Serializable
    data object VerticalFloatingToolbar : Route()

    @Serializable
    data object HorizontalFloatingToolbar : Route()

    @Serializable
    data object FlexibleBottomAppBar : Route()
}
