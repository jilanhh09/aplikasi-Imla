package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Contoh penambahan icon suara di dalam HarakatCard
@Composable
fun HarakatCard(title: String, description: String) {
    Card(/* ... */) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(description, style = MaterialTheme.typography.bodyMedium)
            }
            // Icon suara yang dapat diklik
            Image(
                painter = painterResource(id = R.drawable.sound), // Ganti dengan ikon suara
                contentDescription = "Play sound",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { /* Panggil fungsi untuk memutar suara */ }
            )
        }
    }
}
