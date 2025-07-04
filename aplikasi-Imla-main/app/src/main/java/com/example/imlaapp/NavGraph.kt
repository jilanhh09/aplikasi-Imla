package com.example.imlaapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imlaapp.MainMenu
import com.example.imlaapp.LearnScreen
import com.example.imlaapp.QuizScreen
import com.example.imlaapp.AboutScreen

sealed class Screen(val route:String){
    object Main : Screen ("main")
    object Learn : Screen("learn")
    object Quiz : Screen("quiz")
    object About : Screen("about")
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainMenu(navController)
        }
        composable(Screen.Learn.route) {
            LearnScreen()
        }
        composable(Screen.Quiz.route) {
            QuizScreen()
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
    }
}