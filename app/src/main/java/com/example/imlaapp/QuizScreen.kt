package com.example.imlaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.imlaapp.ui.theme.ImlaappTheme
import androidx.navigation.compose.rememberNavController
import com.example.imlaapp.NavGraph


@Composable
fun QuizScreen(navController : NavHostController){
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        //bg
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription ="Background",
            modifier =Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            horizontalAlignment =  Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            //ini buat  tombol menu nya
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                QuizButton("Comprehension Test", Color (0xFFFFC107)){
                    navController.navigate("quiz_comprehension")
                }
                QuizButton("Listening Test", Color (0xFFFF5722)){
                    navController.navigate("PetunjukListeningTest")
                }
            }

            Spacer (modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun QuizButton(text: String, bgColor: Color, onClick: () -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = bgColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(8.dp)
    ){
        Text(text = text, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}

