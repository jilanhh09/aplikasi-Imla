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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Definisikan warna-warna baru
val ColorPrimaryDark = Color(0xFFFF5722) // oranye gelap untuk Judul
val ColorGold = Color(0xFFFFC107)        // Kuning Emas untuk Skor dan Bintang
val ColorActionOrange = Color(0xFFFF8F00) // Oranye cerah untuk tombol primer
val ColorActionBlue = Color(0xFF4DB6AC)   // Biru muda untuk tombol sekunder

@Composable
fun ResultScreen(score: Int, total: Int, navController: NavHostController) {
    // Menghitung rating bintang (maks 5 bintang)
    // Misalnya, 5/10 = 2.5 bintang, 8/10 = 4 bintang.
    val maxStars = 5
    val rating = (score.toFloat() / total.toFloat()) * maxStars
    val fullStars = rating.toInt()
    val hasHalfStar = (rating - fullStars) > 0.4
    val emptyStars = maxStars - fullStars - if (hasHalfStar) 1 else 0

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // JUDUL UTAMA
            Text(
                text = "Selamat! Ini Hasilmu",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = ColorPrimaryDark,

            )

            Spacer(modifier = Modifier.height(24.dp))

            // SKOR BESAR
            Text(
                text = "$score / $total",
                // Ukuran lebih besar dari displayMedium
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                color = ColorGold // Warna Emas
            )

            Spacer(modifier = Modifier.height(8.dp))

            // PESAN MOTIVASI
            val motivationalMessage = when {
                score == total -> "Luar Biasa! Semua Benar! 🤩"
                score >= total * 0.7 -> "Hebat! Pertahankan nilaimu! ✨"
                score >= total / 2 -> "Bagus! Kamu Hampir Mencapai Puncak! 👍"
                else -> "Semangat! Coba Lagi Pasti Bisa! 💪"
            }

            Text(
                text = motivationalMessage,
                style = MaterialTheme.typography.titleMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(40.dp))

            // BINTANG PENILAIAN (Rating)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Bintang Terisi Penuh
                repeat(fullStars) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Bintang Penuh",
                        tint = ColorGold, // Warna Emas
                        modifier = Modifier.size(56.dp)
                    )
                }

                // Bintang Kosong/Border
                repeat(emptyStars) {
                    Icon(
                        imageVector = Icons.Outlined.StarBorder,
                        contentDescription = "Bintang Kosong",
                        tint = Color.LightGray.copy(alpha = 0.5f), // Warna abu-abu yang lebih lembut
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            // TOMBOL AKSI 1: COBA LAGI (Primer)
            Button(
                onClick = {
                    // Logika untuk navigasi ke halaman kuis lagi (misal: "quiz_comprehension")
                    navController.popBackStack() // Kembali ke layar sebelumnya (kuis)
                    // Jika butuh navigasi ke layar kuis pertama kali, gunakan:
                    // navController.navigate("quiz_comprehension")
                },
                colors = ButtonDefaults.buttonColors(containerColor = ColorActionOrange), // Oranye
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "Coba Lagi",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // TOMBOL AKSI 2: MENU UTAMA (Sekunder)
            Button(
                onClick = {
                    // Logika untuk kembali ke Menu Utama (misal: "main")
                    navController.navigate("main") {
                        // Bersihkan stack agar tidak bisa back ke halaman kuis
                        popUpTo("main") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = ColorActionBlue), // Biru Muda
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "Menu Utama",
                    style = MaterialTheme.typography.titleMedium,
                    color = ColorPrimaryDark //
                )
            }
        }
    }
}