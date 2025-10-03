package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//batas maksimal pengulangan audio yang diizinkan sebanyak 2 kali
const val MAX_REPEAT = 2

@Composable
fun ListeningTestScreen(
    navController: NavHostController,
    speakerIconResId: Int = R.drawable.sound,
    backgroundResId: Int = R.drawable.bg,

    ) {
    var repeatCount by remember { mutableIntStateOf(0) }
    val isFinishedPlaying = remember { derivedStateOf { repeatCount >= MAX_REPEAT } }

    Box(modifier = Modifier.fillMaxSize()) {


        if (backgroundResId != 0) { // Cek agar tidak error jika placeholder
            Image(
                painter = painterResource(id = backgroundResId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f //
            )
        } else {
            // Fallback: Jika tidak ada background, gunakan warna solid
            Spacer(modifier = Modifier.fillMaxSize().background(Color.White))
        }


        // Konten utama diletakkan di atas Background
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Tes Imla' - Dikte Arab", fontSize = 24.sp, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = "Level 1: Dengarkan dan tulis di buku Anda. Maksimal 2x.",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Spacer(modifier = Modifier.height(64.dp))

            // 2. Gunakan Ikon Suara Anda di AudioButton
            AudioButton(
                iconResId = speakerIconResId,
                isEnabled = !isFinishedPlaying.value,
                onPlayClicked = {
                    // Logic untuk memutar audio
                    // ... playAudio() ...
                    repeatCount++
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Pengulangan: $repeatCount/$MAX_REPEAT",
                fontSize = 16.sp,
                color = if (isFinishedPlaying.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(64.dp))

            // Tombol Selesai
            Button(
                // Panggil navigasi ke layar berikutnya (misal: "answer_screen")
                onClick = {
                    navController.navigate("answer_screen") // Ganti "answer_screen" dengan rute tujuan Anda
                },
                enabled = isFinishedPlaying.value,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Selesai & Cek Jawaban", fontSize = 18.sp)
            }
        }
    }
}

/**
 * Komponen Visual untuk Ikon Suara (menggunakan Resource ID)
 */
@Composable
fun AudioButton(
    iconResId: Int,
    isEnabled: Boolean,
    onPlayClicked: () -> Unit
) {
    val iconTint = if (isEnabled) MaterialTheme.colorScheme.primary else Color.Gray

    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable(enabled = isEnabled, onClick = onPlayClicked),
        shape = androidx.compose.foundation.shape.CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = if (isEnabled) 1f else 0.5f)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Mengganti Icon bawaan dengan Image dari resource ID Anda
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = "Putar Audio",
                contentScale = ContentScale.Fit,
                // Opsional: berikan tint warna pada ikon Anda
                // colorFilter = ColorFilter.tint(iconTint),
                modifier = Modifier.size(70.dp)
            )
        }
    }
}