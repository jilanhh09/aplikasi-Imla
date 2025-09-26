package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController


@Composable
fun ResultScreen(score: Int, total: Int, navController: NavHostController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        //bg
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //judul
            Text(
                text = "Hasil Tes Kamu",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            //skor
            Text(
                text = "$score / $total",
                style = MaterialTheme.typography.displayMedium,
                color =
                    if (score >= total / 2) Color(0xff4caf50)
                    else Color(0xfff44336)
            )

            Spacer(modifier = Modifier.height(8.dp))

            //pesan
            Text(
                text = when {
                    score == total -> "Luar Biasa! Semua Benar🎉"
                    score >= total / 2 -> "Bagus! Tingkatkan Lagi 🥰"
                    else -> "Jangan Menyerah, coba lagi 🥷"
                },
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Bintang penilaian
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                repeat(score) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Bintang Benar",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )
                }
                repeat(total - score) {
                    Icon(
                        imageVector = Icons.Outlined.StarBorder,
                        contentDescription = "Bintang Kosong",
                        tint = Color.LightGray,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Tombol kembali ke menu utama
            Button(
                onClick = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Main.route) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "Kembali ke Menu Utama",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}