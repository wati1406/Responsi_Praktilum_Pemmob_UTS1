package com.example.responsi.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.responsi.viewmodel.GameViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel = viewModel, onGameClick = { gameId ->
                navController.navigate("detail/$gameId")
            })
        }
        composable("detail/{gameId}") { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId")?.toIntOrNull()
            if (gameId != null) {
                DetailScreen(viewModel = viewModel, gameId = gameId, onNavigateBack = {
                    navController.popBackStack()
                })
            }
        }
    }
}
