package com.example.imlaapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Warna :
val ColorBlue = Color(0xFF1E3A8A) // Biru gelap
val ColorOrange = Color(0xFFFF8F00) // Oranye cerah
val ColorMint = Color(0xFF4DB6AC) // Hijau mint (untuk ikon)

@Composable
fun PetunjukListeningTest(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
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
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .verticalScroll(rememberScrollState()), // Membuat bisa di-scroll jika layar kecil
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // JUDUL UTAMA
            Text(
                text = "Petunjuk Listening Test",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = ColorBlue,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            // KOTAK ATURAN
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp))
                    .padding(20.dp)
            ) {

                // --- ATURAN 1: PERSIAPAN ALAT TULIS ---
                InstructionItem(
                    title = "1. Persiapan Alat Tulis! ✏️📚",
                    content = "Ambil buku tulis dan pensil kamu. Tuliskan jawaban kamu di buku, ya! Aplikasi ini cuma membacakan soalnya.",
                    iconColor = ColorOrange
                )

                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(16.dp))

                // --- ATURAN 2 & 3: DENGAR DAN TULIS (2x Kesempatan) ---
                InstructionItem(
                    title = "2. Dengarkan Baik-Baik! 🔊",
                    content = "Klik tombol Speaker untuk dengar suara. Fokus! Suara hanya akan diputar DUA KALI saja (1x awal, 1x klik 'Dengar Lagi'). Setelah itu, kamu tidak bisa mengulanginya.",
                    iconColor = ColorMint
                )

                Spacer(modifier = Modifier.height(8.dp))
                // Menambahkan poin 3 (Tulis Jawabanmu) sebagai bagian dari proses dengar
                Text(
                    text = "✍️ Segera tuliskan jawabanmu di buku setelah selesai mendengarkan (maksimal 2 kali).",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(16.dp))

                // --- ATURAN 4: PERIKSA HASIL ---
                InstructionItem(
                    title = "3. Periksa Hasil! ✅",
                    content = "Kalau kamu sudah yakin, klik 'Periksa Jawaban'. Layar akan menunjukkan jawaban yang benar. Kamu bisa langsung mencocokkan tulisanmu!",
                    iconColor = ColorBlue
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // TOMBOL AKSI: MULAI
            Button(
                onClick = {
                    // Navigasi ke Listening Test Screen
                    navController.navigate("quiz_listening")
                },
                colors = ButtonDefaults.buttonColors(containerColor = ColorActionOrange),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(8.dp)
            ) {
                Text(
                    text = "🚀 MULAI TES IMlA' SEKARANG!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Komponen kecil untuk menampilkan setiap item instruksi
@Composable
fun InstructionItem(title: String, content: String, iconColor: Color) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = iconColor, // Menggunakan warna untuk judul
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.DarkGray
        )
    }
}