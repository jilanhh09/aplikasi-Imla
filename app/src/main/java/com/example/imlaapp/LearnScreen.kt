package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource

@Composable
fun LearnScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        // Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    // konten utama dengan padding
         Column  (modifier = Modifier.padding(16.dp)){
            Text("Pilih Bab untuk Dipelajari", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate(Screen.Bab1.route)}, modifier = Modifier.fillMaxWidth()){
                Text("Bab1 : Huruf Hijaiyah")
        }
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate(Screen.Bab2.route) }, modifier = Modifier.fillMaxWidth()) {
                Text("Bab 2: Menyambung Huruf")
        }
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate(Screen.Bab3.route) }, modifier = Modifier.fillMaxWidth()) {
                Text("Bab 3: Penulisan Kata dan Kalimat")
             }
         }
    }
}


