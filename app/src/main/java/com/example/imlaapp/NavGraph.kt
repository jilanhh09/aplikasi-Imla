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
    object Bab1 : Screen("bab1")
    object Bab2 : Screen("bab2")
    object Bab3 : Screen("bab3")
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
            LearnScreen(navController)
        }
        composable(Screen.Bab1.route){
            Bab1Screen(navController)
        }
        composable(Screen.Bab2.route){
            Bab2Screen(navController)
        }
        composable(Screen.Bab3.route){
            Bab3Screen(navController)
        }
        composable(Screen.Quiz.route) {
            QuizScreen(navController)
        }
        composable(Screen.About.route) {
            AboutScreen(navController)
        }
    }
}