//package tempat file aplikasi
package com.example.imlaapp

//import library android & jetpack compose yang dipakai
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge // Biar layout bisa extend sampai area status bar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.imlaapp.ui.theme.ImlaappTheme
import androidx.navigation.compose.rememberNavController
import com.example.imlaapp.NavGraph


// MainActivity → halaman pertama yang dijalankan saat app dibuka
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktifkan edge-to-edge layout (biar bisa full layar sampai status bar)
        enableEdgeToEdge()
        // setContent → isi UI pakai Compose
        setContent {
            ImlaappTheme {
                // NavController → buat navigasi antar halaman
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

// Main Menu → halaman utama aplikasi
@Composable
fun MainMenu(navController: NavHostController){

    // Box → tumpukan, posisi relatif berdasarkan z-index
    Box(
        modifier = Modifier.fillMaxSize(),//isi seluruh layar
        contentAlignment = Alignment.Center //konten di tengah box
    ){


        //background gambar
        Image(
            painter = painterResource(id = R.drawable.bg),//ambil gambar dari drawable
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),//gambar sebesar layar android
            contentScale = ContentScale.Crop //potong gambar supaya penuh
        )

        // kolom utama konten
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),// jarak dari tepi
            horizontalAlignment = Alignment.CenterHorizontally, // isi ditengah horizontal
            verticalArrangement = Arrangement.Top // mulai dari atas halaman
        ){
            Spacer(modifier = Modifier.height(200.dp)) // jarak dari atas

            //logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )

            Spacer(modifier = Modifier.height(64.dp)) //jarak antara logo dan tombol

            //Tombol Menu
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp), //jarak antara tombol
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                MenuButton("LEARN", Color(0xFFFFC107)){
                    navController.navigate("learn")
                }
                MenuButton("QUIZ", Color(0xFFFF5722)){
                    navController.navigate("quiz")
                }
                MenuButton("ABOUT", Color(0xFF009688)){
                    navController.navigate("about")
                }
            }

        }
    }
}


//fungsi untuk membuat tombol menu dengan style yang sama
@Composable
fun MenuButton(text: String,  bgColor: Color, onClick: () -> Unit){
    Button(
        onClick = onClick, // aksi saat tombol di klik
        colors = ButtonDefaults.buttonColors(containerColor = bgColor),
        modifier = Modifier
            .fillMaxWidth() // lebar penuh
            .height(56.dp), // tinggi tetap
        shape = RoundedCornerShape(28.dp), // rounded corner
        elevation = ButtonDefaults.buttonElevation(8.dp) // efek bayangan
    ) {
        Text(
            text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp))
    }
}