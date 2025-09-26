package com.example.imlaapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imlaapp.MainMenu
import com.example.imlaapp.LearnScreen
import com.example.imlaapp.QuizScreen
import com.example.imlaapp.SplashScreen
import com.example.imlaapp.AboutScreen
import com.example.imlaapp.model.Question


sealed class Screen(val route:String){
    object Splash : Screen("splash")
    object Main : Screen ("main")
    object Learn : Screen("learn")
    object Bab1 : Screen("bab1")
    object Bab2 : Screen("bab2")
    object Bab3 : Screen("bab3")
    object Quiz : Screen("quiz")
    object About : Screen("about")
    object ComprehensionTest : Screen("quiz_comprehension")
    object ListeningTest : Screen("quiz_listening")

}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route){
            SplashScreen(navController)
        }
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
        composable(Screen.ListeningTest.route) {
            ListeningTestScreen(navController)
        }
        composable(Screen.ComprehensionTest.route) {
            ComprehensionTestScreen(navController)
        }

        composable("result/{score}/{total}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
            val total = backStackEntry.arguments?.getString("total")?.toIntOrNull() ?: 0
            ResultScreen(score = score, total = total, navController = navController)
        }
    }
}