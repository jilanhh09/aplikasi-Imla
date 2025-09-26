package com.example.imlaapp

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext



@Composable
fun ListeningTestScreen(navController: NavHostController) {
    //state
    var playCount by remember { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }

    //media player
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.listening)}

    //ui
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        //bg
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        //konten tengah
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            if(!showAnswer){
                Icon(
                    painter = painterResource(id = R.drawable.sound),
                    contentDescription = "play",
                    modifier = Modifier
                        .size(120.dp)
                        .clickable {
                            if(playCount <3){
                                mediaPlayer.start()
                                playCount++
                            }
                        }
                )
                Text("Diputar:$playCount/3 kali")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {showAnswer = true},
                    enabled = playCount >=1,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA726))
                ){
                    Text("Finish")
                }
            } else {
                Text(
                    text = "Jawaban",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFFFF7043))
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "المَدْرَسَةُ مَفْتُوحَةٌ فِي الصَّبَاحِ...",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )

                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = {
                    navController.navigate(Screen.Main.route){
                        popUpTo(Screen.Main.route){inclusive = true}
                    }
                }) {
                    Text("kembali ke menu")
                }
            }
        }
    }
}