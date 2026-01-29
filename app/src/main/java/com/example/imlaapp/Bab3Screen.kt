package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Bab3Screen(navController: NavHostController) {
    val contentColor = Color.Black
    val headerColor = Color(0xFFD35400)

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg_1),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 2. Konten utama
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp)

        ) {


            item {
                Spacer(modifier = Modifier.height(64.dp))
                // Judul Bab
                Text(
                    "Bab 3: Penulisan Huruf Hamzah (ء)",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.White.copy(alpha = 0.8f),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    color = headerColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Pengantar
                Text(
                    "Huruf Hamzah (ء) memiliki cara penulisan unik. Hamzah dapat ditulis di atas huruf Alif, Wau, Ya, atau berdiri sendiri , tergantung posisinya dan harakatnya. Ada tiga jenis penulisan Hamzah:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = contentColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Hamzah di Awal
                HamzahAwalSection(contentColor)
                Spacer(modifier = Modifier.height(16.dp))

                // Pemisah visual
                Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))

                // Hamzah di Tengah
                HamzahTengahSection(contentColor)
                Spacer(modifier = Modifier.height(16.dp))

                // Pemisah visual
                Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))

                // Hamzah di Akhir
                HamzahAkhirSection(contentColor)

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
        //TOMBOL kembali
        IconButton(
            onClick = { navController.popBackStack() }, // pake popBackStack agar kembali ke layar sebelumnya
            modifier = Modifier
                .statusBarsPadding() // Agar tidak kena notch/jam di HP
                .padding(start = 16.dp, top = 8.dp)
                .size(40.dp)
                .background(
                    color = Color(0xFFFF5722), // Merah
                    shape = androidx.compose.foundation.shape.CircleShape
                )
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Kembali",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

// ==========================================================
// Komponen 1: Hamzah di Awal Kata (Hamzah Qath'i)
// ==========================================================
@Composable
fun HamzahAwalSection(contentColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8F8F5).copy(alpha = 0.7f), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            "1. Hamzah di Awal Kata",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF27AE60) // Hijau
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Ketika Hamzah berada di awal kata, ia selalu ditulis di atas huruf Alif (ا).",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Aturan Penempatan:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
        Text("• Di atas Alif jika berharakat Fathah (أ) atau Dhamah (أ)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Di bawah Alif jika berharakat Kasrah (إ)", style = MaterialTheme.typography.bodyLarge, color = contentColor)

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Contoh: أَحَدٌ (Ahadun), أُكْتُبْ (Uktub), إِبْرَةٌ (Ibratun)",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = contentColor
        )
    }
}

// ==========================================================
// Komponen 2: Hamzah di Tengah Kata (Hamzah Mutawassithah)
// ==========================================================
@Composable
fun HamzahTengahSection(contentColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFAF0).copy(alpha = 0.7f), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            "2. Hamzah di Tengah Kata",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC0392B) // Merah Bata
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Penulisannya berdasarkan harakat Hamzah dan huruf sebelumnya.",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Jika  Kasrah: ditulis di atas Ya' tanpa titik (ئ). Contoh: سُئِلَ (Su'ila)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Jika  Dhamah: ditulis di atas Wau (ؤ). Contoh: مُؤْمِنٌ (Mu'minun)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Jika  Fathah: ditulis di atas Alif (أ). Contoh: رَأْسٌ (Ra'sun)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
    }
}

// ==========================================================
// Komponen 3: Hamzah di Akhir Kata (Hamzah Mutathorrifah)
// ==========================================================
@Composable
fun HamzahAkhirSection(contentColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F8FF).copy(alpha = 0.7f), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            "3. Hamzah di Akhir Kata",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2980B9) // Biru
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Penulisannya hanya melihat harakat huruf sebelum Hamzah.",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text("• Jika didahului Kasrah: ditulis di atas Ya' tanpa titik (ئ). Contoh : شَاطِئٌ (Shāti'un)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Jika didahului Dhamah: ditulis di atas Wau (ؤ). Contoh: تَبَوُّءُ (Tabawwu'u)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Jika didahului Fathah: ditulis di atas Alif (أ). Contoh: نَبَأٌ (Naba'un)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
        Text("• Jika didahului Sukun/Mad: ditulis berdiri sendiri (ء). Contoh: مَاءٌ (Mā'un), شَيْءٌ (Shai'un)", style = MaterialTheme.typography.bodyLarge, color = contentColor)
    }
}