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
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight


// ID Resource untuk musik latar
val BGM_RES_ID = R.raw.bgmusic

// State yang dapat diobservasi oleh Composable UI
val isMusicPlayingState = mutableStateOf(false)
val ContrastingColor = Color(0xFF009688)

object BackgroundMusicPlayer {
    private var mediaPlayer: MediaPlayer? = null

    // Status Play/Pause yang terhubung dengan state Compose
    val isPlaying: Boolean
        get() = isMusicPlayingState.value

    fun getPlayer(context: Context, audioResId: Int): MediaPlayer? {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, audioResId).apply {
                isLooping = true // Musik berulang
            }
        }
        return mediaPlayer
    }

    fun start(context: Context, audioResId: Int){
        val player = getPlayer(context, audioResId)
        if (player?.isPlaying == false){
            player?.start()
            isMusicPlayingState.value = true
        }
    }

    fun pause(){
        if (mediaPlayer?.isPlaying == true){
            mediaPlayer?.pause()
            isMusicPlayingState.value = false
        }
    }

    // Fungsi untuk mengubah status Play/Pause
    fun toggle(context: Context, audioResId: Int) {
        if (isMusicPlayingState.value) {
            pause()
        } else {
            start(context, audioResId)
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
        isMusicPlayingState.value = false
    }
}

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

    val context = LocalContext.current

    DisposableEffect(key1 = Unit) {
        BackgroundMusicPlayer.start(context, BGM_RES_ID) //ketika buka mainmenu music nyala

        onDispose {
            BackgroundMusicPlayer.pause()//ini pause music ketika ke halaman lain
        }
    }

    // Ambil status musik dari state global agar ikon berubah otomatis
    val isMusicPlaying = isMusicPlayingState.value

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

        // **[TAMBAHAN: Ikon Kontrol Musik di Sudut Kanan Atas]**
        IconButton(
            onClick = {
                // Panggil fungsi toggle
                BackgroundMusicPlayer.toggle(context, BGM_RES_ID)
            },
            modifier = Modifier
                .align(Alignment.TopEnd) // Posisikan di kanan atas
                .padding(16.dp) // Beri jarak dari tepi
                .size(50.dp)
        ) {
            Icon(
                // Ikon berubah tergantung status musik
                imageVector = if (isMusicPlaying)
                    Icons.Default.VolumeUp
                else
                    Icons.Default.VolumeOff,
                contentDescription = "Kontrol Musik",
                tint = ContrastingColor,
                modifier = Modifier.size(45.dp)
            )
        }

        // kolom utama konten
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),// jarak dari tepi
            horizontalAlignment = Alignment.CenterHorizontally, // isi ditengah horizontal
            verticalArrangement = Arrangement.Top // mulai dari atas halaman
        ){
            Spacer(modifier = Modifier.height(180.dp)) // jarak dari atas

            //logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )

            Spacer(modifier = Modifier.height(48.dp)) //jarak antara logo dan tombol

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
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp))
    }
}