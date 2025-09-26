package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Data class untuk isi tabel
data class LetterExample(
    val contohAkhir: String,
    val akhir: String,
    val contohTengah: String,
    val tengah: String,
    val contohAwal: String,
    val awal: String,
    val hurufAsli: String
)

@Composable
fun Bab1Screen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Gambar background
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Konten utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Bab 1: Merangkai Huruf",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Semua huruf hijaiyah bisa menyambung dengan huruf sebelumnya, " +
                                "tapi tidak semua bisa bersambung dengan huruf setelahnya.\n\n" +
                                "Huruf yang tidak bisa bersambung adalah: ا و ز ر ذ د\n" +
                                "Huruf yang dapat bersambung adalah: ي ه ن م ل ك ق ف غ ع ظ ط ض ص ش س خ ح ج ث ت ب",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Berikut ini tabel penulisan huruf hijaiyah bersambung:",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Daftar huruf dalam tabel
                    LazyColumn(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        items(letterExamples) { item ->
                            LetterRow(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LetterRow(example: LetterExample) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Contoh", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(example.contohAkhir, fontSize = 16.sp)
                Text(example.akhir, fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Contoh", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(example.contohTengah, fontSize = 16.sp)
                Text(example.tengah, fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Contoh", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(example.contohAwal, fontSize = 16.sp)
                Text(example.awal, fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Huruf Asli", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(example.hurufAsli, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// ====== Data Dummy ======
// Anda isi sesuai tabel panjang yang Anda punya
val letterExamples = listOf(
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "…..ــــثــــ….", "ثَـوْبٌُ", "ثــ…..", "ث"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
    LetterExample("اَنَا", "ـــا", "يَشَاءُ", "ــاــ", "اَلْحَمْدُ", "ا...", "ا"),
    LetterExample("اَلْغَيْبُ", "ـــب", "نَعْبُدُ", "ــبــ", "بِسْمِ", "بـ...", "ب"),
    LetterExample("اَلْبَيْتُ", "ــت", "نَسْتَعِيْنُ", "ــتــ", "تَرْمِيْهِمْ", "تـ...", "ت"),
)
