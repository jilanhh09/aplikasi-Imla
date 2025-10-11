package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
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
            painter = painterResource(id = R.drawable.bg_1),
            contentDescription = "Background Learn",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp,vertical = 24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    "Bab 1: Merangkai Huruf Hijaiyah",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.White.copy(alpha = 0.8f), // Beri sedikit latar belakang transparan
                            RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    color = Color(0xFFD35400) // Warna oranye seperti di gambar
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Teks Materi
                Text(
                    "Semua **huruf hijaiyah** bisa menyambung dengan huruf sebelumnya, " +
                            "tapi tidak semua bisa bersambung dengan huruf setelahnya.\n\n" +
                            "**Huruf yang tidak bisa bersambung** ke kiri (hanya ke kanan) adalah: **ا و ز ر ذ د**\n" +
                            "**Huruf yang dapat bersambung** dari kedua sisi adalah: **ي ه ن م ل ك ق ف غ ع ظ ط ض ص ش س خ ح ج ث ت ب**",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    "Berikut ini tabel penulisan huruf hijaiyah bersambung:",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = contentColor
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Header Tabel
                TableHeader()
            }
            // Daftar huruf dalam tabel
            items(letterExamples){item ->
                Column(modifier = Modifier.background(Color.White.copy(alpha = 0.7f))) {
                    LetterRow(item)
                    Divider(color = Color.LightGray, thickness = 1.dp)

                }
            }
        }
    }
}

// Komponen Header Tabel
@Composable
fun TableHeader() {
    val headerColor = Color(0xFFF0F0F0) // Warna abu-abu muda untuk header
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(headerColor),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        HeaderCell("Di Akhir", 0.25f)
        HeaderCell("Di Tengah", 0.25f)
        HeaderCell("Di Awal", 0.25f)
        HeaderCell("Huruf Asli", 0.15f)
    }
    Divider(color = Color.Black, thickness = 2.dp)
}

@Composable
fun RowScope.HeaderCell(text: String, weight: Float) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(vertical = 8.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color.Black
    )
}
// Komponen Baris Data Tabel
@Composable
fun LetterRow(example: LetterExample) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Kolom Di Akhir
        DataCell(example.contohAkhir, example.akhir, 0.25f)
        // Kolom Di Tengah
        DataCell(example.contohTengah, example.tengah, 0.25f)
        // Kolom Di Awal
        DataCell(example.contohAwal, example.awal, 0.25f)
        // Kolom Huruf Asli
        Column(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(example.hurufAsli, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun RowScope.DataCell(contoh: String, bentuk: String, weight: Float) {
    Column(
        modifier = Modifier
            .weight(weight)
            .fillMaxHeight()
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Contoh Kata
        Text(
            text = contoh,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        // Bentuk Sambungan (kecil di bawah contoh)
        Text(
            text = bentuk,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    }
    VerticalDivider(color = Color.LightGray, thickness = 1.dp)
}

@Composable
fun VerticalDivider(color: Color, thickness: Dp) {
    Spacer(modifier = Modifier.width(thickness).fillMaxHeight().background(color))
}

// ====== Data Huruf Hijaiyah Bersambung Lengkap ======
val letterExamples = listOf(
    // Huruf Alif (ا) - Kanan Boleh, Kiri Putus
    LetterExample("اَنَا", "…ـــا", "يَشَاءُ", "…..ــا……", "اَلْحَـمْدُ", "ا……", "ا"),
    // Huruf Ba' (ب)
    LetterExample("اَلْغَيْبُ", "….ـــــب", "نَـعْبُدُ", "….ــــبـــ…", "بـــِــسْمِ", "بـ……", "ب"),
    // Huruf Ta' (ت)
    LetterExample("اَلْبَيْتُ", "….ـــــت", "نَـسْتَعِـيـْنُ", "….ــتــ…..", "تَـرْمِيْهِمْ", "تـ……", "ت"),
    // Huruf Tsa' (ث)
    LetterExample("حَـدِيْثُ", "…ــــــث", "مَـثَلُهُمْ", "…..ــــثــــ….","ثَـوْبٌ", "ثــ…..", "ث"),
    // Huruf Jim (ج)
    LetterExample("ثَـلْـجٌ", "…ــج", "يَـسْجُـدُ", "…جـ…", "جَسَـدٌ", "جـ…", "ج"),
    // Huruf Ha' (ح)
    LetterExample("اَلْمَسِيْحُ", "…ــح", "يَـحْسُدُ", "…ــحـ…", "حَسَـدٌ", "حـ…", "ح"),
    // Huruf Kha' (خ)
    LetterExample("نَنْسَخْ", "…ــخ", "يَـخْشَى", "…ــخـ…", "خَشِيَ", "خـ…", "خ"),
    // Huruf Dal (د) - Kanan Boleh, Kiri Putus
    LetterExample("مَسَـدٌ", "….ــد", "فَقَدَرَ", "…ــد….","دُكَتْ", "د…", "د"),
    // Huruf Dzal (ذ) - Kanan Boleh, Kiri Putus
    LetterExample("يَــوْمَـئِـذٍ", "…ــذ", "يَذْهَبُ", "…ــذ…", "ذَهَبَ", "ذ…", "ذ"),
    // Huruf Ra' (ر) - Kanan Boleh, Kiri Putus
    LetterExample("تَـنْهَرُ", "…ــر", "يَـرْضَى", "…ــر…", "رَضِـيَ", "ر…", "ر"),
    // Huruf Zai (ز) - Kanan Boleh, Kiri Putus
    LetterExample("نُعْجِزُ", "…ــز", "مِيْـزَانٌ", "…ـــز…", "زَمَنٌ", "ز…", "ز"),
    // Huruf Sin (س)
    LetterExample("لَيْسَ", "…ــس", "يَسْأَلُ", "…ــســ…", "سَأَلَ", "سـ…", "س"),
    // Huruf Syin (ش)
    LetterExample("إِخْشَ", "…ــش", "يَشْهَدُ", "…ــشــ…", "شَجَرَةٌ", "شـ…", "ش"),
    // Huruf Shad (ص)
    LetterExample("يُـخْلِصُ", "…ــص", "يَصْدُرُ", "…ــصــ…", "صَدَرَ", "صــ…", "ص"),
    // Huruf Dhad (ض)
    LetterExample("بَعْضُ", "…ــض", "يَضْحَكُ", "…ــضــ…", "ضَحِكَ", "ضــ…", "ض"),
    // Huruf Tha' (ط)
    LetterExample("سَلَطَ", "…ــط", "يَـنْـطِـقُ", "…ــطــ…", "طَبَـقٌ", "طــ…", "ط"),
    // Huruf Zha' (ظ)
    LetterExample("غَلَظَ", "…ــظ", "يَظْهَرُ", "…ــظــ…", "ظَهَرَ", "ظــ…", "ظ"),
    // Huruf 'Ain (ع)
    LetterExample("مَنَـعَ", "…ــع", "يَــنْعِقُ", "…ــعــ…", "عَـيْـنٌ", "عــ…", "ع"),
    // Huruf Ghain (غ)
    LetterExample("بَلَغَ", "…ـــغ", "يَـغْضَبُ", "…ــغــ…", "غَضِبَ", "غــ…", "غ"),
    // Huruf Fa' (ف)
    LetterExample("يُوسُفُ", "…ــف", "يَـفْـقَـهُ", "…ــفــ…", "فِيْهَا", "فــ…", "ف"),
    // Huruf Qaf (ق)
    LetterExample("خَلَـقَ", "…ــق", "يَـقْرَأُ", "…ــقــ…", "قَرِيْبٌ", "قــ…", "ق"),
    // Huruf Kaf (ك)
    LetterExample("مَلَكَ", "…ــك", "يَكْتُبُ", "…ــكـ…", "كَتَبَ", "كــ…", "ك"),
    // Huruf Lam (ل)
    LetterExample("عَسَلٌ", "…ــل", "يَلْعَبُ", "…ــلــ…", "لَـهَبٍ", "لـ…", "ل"),
    // Huruf Mim (م)
    LetterExample("الرَحِيْمُ", "…ــم", "يَـمْكُثُ", "…ــمــ…", "مَسْجِدٌ", "مــ…", "م"),
    // Huruf Nun (ن)
    LetterExample("الرَحْـمَنُ", "…ــن", "جَهَنَمُ", "…ــنــ…", "نَعْقِلُ", "نــ…", "ن"),
    // Huruf Wau (و) - Kanan Boleh, Kiri Putus
    LetterExample("عَجِبُوْ", "…ــو", "فَسَوْفَ", "…ــو…", "وَصَلَ", "و…", "و"),
    // Huruf Ha' (هـ)
    LetterExample("مَالَهُ", "…ــه", "يَهْدِى", "…ــهـ…", "هَــذَا", "هــ…", "هـ"),
    // Huruf Lam Alif (لا) - Kanan Boleh, Kiri Putus
    LetterExample("طِفْلاً", "…ــلا", "يُلاَعِــنُ", "…ــلا…", "لاَعَـنَ", "لا…", "لا"),
    // Huruf Hamzah (ء)
    LetterExample("يَشَاءُ", "…ء", "يَسْتَهْـزِءُوْنَ", "…ء…", "ءَ أَنْتَ", "ء…", "ء"),
    // Huruf Ya' (ي)
    LetterExample("يَسْتَحْيِ", "…ــي", "شَيْئًا", "…ــيـ…", "يَغْفِـرَ", "يـ…", "ي")
)