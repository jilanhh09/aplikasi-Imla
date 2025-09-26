package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.imlaapp.HarakatCard


@Composable
fun Bab2Screen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Bab 2",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Bab 2: Menyambung Huruf Hijaiyyah dalam Kata",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Dalam bahasa Arab, tidak semua huruf bisa menyambung dari kedua sisi. Berikut pembagiannya:",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Kategori 1
            HarakatCard(
                title = "Huruf yang Bisa Menyambung dan Disambung",
                description = "Contoh huruf: ب، ت، ث، ج، ح، خ، س، ش، ص، ض، ط، ظ، ع، غ، ف، ق، ك، ل، م، ن، هـ، ي"
            )

            // Kategori 2
            HarakatCard(
                title = "Huruf yang Tidak Bisa Menyambung dari Kanan",
                description = "Contoh huruf: ا، د، ذ، ر، ز، و\nHuruf ini tidak dapat menyambung ke huruf setelahnya."
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Contoh kata dengan huruf tersambung:\nمَدْرَسَة (madrasah), كِتَاب (kitab)",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
