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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.imlaapp.HarakatCard


@Composable
fun Bab2Screen(navController: NavHostController) {
    val contentColor = Color.Black // Warna teks utama
    val headerColor = Color(0xFFD35400) // Warna oranye untuk judul

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_1),
            contentDescription = "Background Bab 2",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 2. Konten utama (tanpa Card putih)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(64.dp))
                // Judul Bab
                Text(
                    "Bab 2: Alif Lam Syamsiyah dan Qomariyah",
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
                    "Ketika huruf **Alif Lam (ال)** bertemu dengan huruf hijaiyah lainnya, cara membacanya terbagi menjadi dua hukum: **Idzhar Qomariyah** dan **Idgham Syamsiyah**.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = contentColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))

                // --- Syamsiyah ---
                SyamsiyahSection(contentColor)

                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))

                // --- Qomariyah ---
                QomariyahSection(contentColor)

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}


// Komponen Khusus untuk Alif Lam Syamsiyah

@Composable
fun SyamsiyahSection(contentColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFAF0).copy(alpha = 0.7f), RoundedCornerShape(8.dp)) // Latar belakang ringan
            .padding(12.dp)
    ) {
        Text(
            "1. Alif Lam Syamsiyah (Idgham Syamsiyah)",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC0392B) // Merah bata
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Alif Lam (**ال**) bertemu salah satu dari 14 huruf Syamsiyah. **Huruf Lam (ل) tidak dibaca** dan dileburkan (di-idghamkan) ke huruf berikutnya, yang diberi tanda **Tasydid** ($\text{ّ}$)",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Huruf-huruf Syamsiyah
        Text(
            "Hurufnya ada 14: **ت ث د ذ ر ز س ش ص ض ط ظ ل ن**",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Contoh
        Text(
            "Contoh:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
        Text(
            "**اَلدِّيْنُ** (ad-Dīnu) → **لَام** hilang, huruf **د** dibaca tasydid.",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )
        Text(
            "**اَلشَّمْسُ** (asy-Syamsu) → **لَام** hilang, huruf **ش** dibaca tasydid.",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )
    }
}


// Komponen Khusus untuk Alif Lam Qomariyah
@Composable
fun QomariyahSection(contentColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8F8F5).copy(alpha = 0.7f), RoundedCornerShape(8.dp)) // Latar belakang ringan
            .padding(12.dp)
    ) {
        Text(
            "2. Alif Lam Qomariyah (Idzhar Qomariyah)",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF27AE60) // Hijau
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Alif Lam (**ال**) bertemu salah satu dari 14 huruf Qomariyah. **Huruf Lam (ل) dibaca jelas** dan diberi tanda **Sukun** ($\text{ْ}$).",
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Huruf-huruf Qomariyah
        Text(
            "Hurufnya ada 14: **ا ب غ ح ج ك و خ ف ع ق ي م ه**",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Contoh
        Text(
            "Contoh:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
        Text(
            "**اَلْقَمَرُ** (al-Qomaru) → **لَام** dibaca jelas (sukun).",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )
        Text(
            "**اَلْبَيْتُ** (al-Baitu) → **لَام** dibaca jelas (sukun).",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )
    }
}

