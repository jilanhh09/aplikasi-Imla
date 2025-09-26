package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun LearnScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        // Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    // konten utama dengan padding
         Column  (
             modifier = Modifier
                 .fillMaxSize()
                 .padding(20.dp),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Top
         ){
             Spacer(modifier = Modifier.height(100.dp))

             //text
             Text(
                "Pilih Bab untuk Dipelajari",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(100.dp))

             Column (
                 verticalArrangement = Arrangement.spacedBy(25.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                 modifier = Modifier.fillMaxWidth()
             ){
                 //menggunakan gambar untuk btn nya (ini bab 1)
                 Image(
                     painter = painterResource(id = R.drawable.btn_bab1),
                     contentDescription = "Tombol Bab 1",
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(150.dp)
                         .clickable { navController.navigate(Screen.Bab1.route) }
                 )

                 //ini bab 2
                 Image(
                     painter = painterResource(id = R.drawable.btn_bab2),
                     contentDescription = "Tombol Bab 1",
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(150.dp)
                         .clickable { navController.navigate(Screen.Bab2.route) }
                 )

                 //ini bab 3
                 Image(
                     painter = painterResource(id = R.drawable.btn_bab3),
                     contentDescription = "Tombol Bab 1",
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(150.dp)
                         .clickable { navController.navigate(Screen.Bab3.route) }
                 )
             }
         }
    }
}



