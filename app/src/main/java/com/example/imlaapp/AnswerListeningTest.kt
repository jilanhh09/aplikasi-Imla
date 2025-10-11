package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

val BACKGROUND_RES_ID = R.drawable.bg
// --- 1. Data Kata Arab ---
// Daftar kata Arab untuk ditampilkan (sesuai gambar)
val daftarKataArab = listOf(
    "الْكِتَابُ",
    "السَّمَاءُ",
    "جُزْءٌ",
    "ذَهَبَ",
    "الشَّمْسُ",
    "قَرَأَ",
    "الضُّحَىٰ",
    "الْأَرْضُ",
    "الصَّلَاةُ",
    "الْجِبَالُ"
)

// --- 2. Composable Halaman Kunci Jawaban ---
@Composable
fun AnswerListeningTest(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Gunakan Scaffold untuk struktur halaman standar
    Scaffold (
       containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
           modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = BACKGROUND_RES_ID),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            // Atur agar konten memenuhi ruang dan berada di tengah (untuk tombol)
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(64.dp))

            // Judul
            Text(
                text = "Periksa Jawaban Anda!",
                textAlign = TextAlign.Start,
                fontSize = 30.sp,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            )

            // --- Daftar Jawaban/Kunci ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.End // Rata kanan untuk tulisan Arab
            ) {
                daftarKataArab.forEachIndexed { index, kata ->
                    val nomor = index + 1

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        // Atur penempatan konten ke kanan
                        horizontalArrangement = Arrangement.End
                    ) {
                        // Teks Arab
                        Text(
                            text = kata,
                            color = Color.Black,
                            fontSize = 32.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        // Nomor Urut
                        Text(
                            text = "$nomor.",
                            color = Color.Black,
                            fontSize = 32.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            // --- Tombol Aksi ---
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                // Tombol Coba Lagi / Ulang Kuis
                Button(text = "COBA LAGI", bgColor = Color(0xFFFF5722)) {
                    // **GANTI "rute_dikte" dengan rute ke halaman Dikte/Quiz Anda**
                    // Ini akan membersihkan stack dan pindah ke halaman dikte/quiz
                    navController.popBackStack()
                    navController.navigate("ListeningTestScreen")
                }

                // Tombol Kembali ke Menu Utama
                Button(text = "MENU UTAMA", bgColor = Color(0xFF4CAF50)) {
                    navController.popBackStack(route = "main", inclusive = false )
                }
            }
        }
    }
    }
}

// Catatan: Pastikan fungsi MenuButton sudah ada di project Anda (di MainActivity.kt)
// atau definisikan ulang di sini jika terpisah:
@Composable
fun Button(text: String,  bgColor: Color, onClick: () -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = bgColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp),
        elevation = ButtonDefaults.buttonElevation(8.dp)
    ) {
        Text(
            text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp))
    }
}