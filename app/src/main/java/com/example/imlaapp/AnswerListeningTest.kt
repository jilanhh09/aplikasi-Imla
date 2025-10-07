package com.example.imlaapp

import com.example.imlaapp.AnswerListeningTest
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerListeningTest(navController: NavHostController) {
    BackHandler {
        navController.navigate(Screen.Main.route)
    }
    Box(modifier = Modifier.fillMaxSize()
    ) {
        // Background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Konten utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(120.dp)
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Aplikasi Al-Imla'",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF009688)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Aplikasi ini dikembangkan untuk membantu siswa dalam pembelajaran Imla' (dikte Bahasa Arab) dengan fitur belajar dan kuis interaktif.",
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Developer : Jilan Haniyah (NIM: 432022618022)\n" +
                                "Dosen Pembimbing : \n" +
                                "1. Dihin Muriyatmoko, S.ST.,M.T\n"+
                                "2. Dian Fikrianti S.SI.,M.Mat",
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Versi 1.0\n© 2025 Jilan Haniyah",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
