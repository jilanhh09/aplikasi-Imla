package com.example.imlaapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Bab3Screen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        //ini background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Bab 3",
            contentScale = ContentScale.Crop,

        )
    }
}
