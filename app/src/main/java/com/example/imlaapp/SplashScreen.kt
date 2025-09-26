package com.example.imlaapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Gunakan LaunchedEffect untuk mengatur delay dan navigasi
    LaunchedEffect(key1 = true) {
        // Tahan selama 1500 milidetik (1.5 detik)
        delay(1500L)

        // Navigasi ke rute HOME, dan hapus rute SPLASH dari back stack
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    // Tampilan Splash Screen Kustom
    Box(
        modifier = Modifier.fillMaxSize(), // Box mengisi seluruh layar
        contentAlignment = Alignment.Center // Konten di tengah Box (PENTING!)
    ) {
        //  Background Gambar
        Image(
            painter = painterResource(id = R.drawable.bg), // ID gambar Background
            contentDescription = "Background Splash Screen",
            modifier = Modifier.fillMaxSize(), // Gambar mengisi seluruh Box
            contentScale = ContentScale.Crop // Memotong gambar agar pas mengisi layar
        )

        //  Logo Aplikasi
        Image(
            painter = painterResource(id = R.drawable.logo), // ID gambar Logo
            contentDescription = "Logo Aplikasi Imla",
            modifier = Modifier.size(200.dp) // Ukuran Logo
        )
    }

}
