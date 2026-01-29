package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight

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
                color = Color.Black,
                 fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(100.dp))

             Column (
                 verticalArrangement = Arrangement.spacedBy(10.dp),
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



