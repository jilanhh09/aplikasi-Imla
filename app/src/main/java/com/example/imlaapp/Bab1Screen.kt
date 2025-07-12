package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.imlaapp.HarakatCard


@Composable
fun Bab1Screen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Konten utama
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Bab 1: Harakat dan Sukun", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Materi tentang huruf hijaiyah akan ditampilkan di sini.", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))

            HarakatCard("Fathah ( ـَ )", "Tanda strip miring di atas huruf, menandakan bunyi 'a'.\nContoh: بَ = ba")
            HarakatCard("Kasrah ( ـِ )", "Tanda strip miring di bawah huruf, menandakan bunyi 'i'.\nContoh: بِ = bi")
            HarakatCard("Dhammah ( ـُ )", "Tanda seperti huruf wawu kecil di atas huruf, menandakan bunyi 'u'.\nContoh: بُ = bu")
            HarakatCard("Sukun ( ـْ )", "Tanda kecil seperti kepala huruf ha, menandakan huruf mati (tidak berharakat).\nContoh: بْ = b")
        }
    }
}


