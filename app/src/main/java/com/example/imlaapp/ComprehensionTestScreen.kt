package com.example.imlaapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ComprehensionTestScreen(navController: NavHostController) {
    // Ambil data soal (anggap QuestionData sudah ada)
    val questions = remember { QuestionData.comprehensionQuestions }

    // State: gunakan mutableIntStateOf untuk Int (saran performa)
    var currentIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var showAnswer by remember { mutableStateOf(false) }

    val question = questions[currentIndex]

    Box(modifier = Modifier.fillMaxSize()) {
        // Background full-screen (gambar/gradient)
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Konten utama (scrollable agar muat di HP kecil)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .padding(top = 75.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Keterangan soal
                Text(
                    text = "Soal ${currentIndex + 1} dari ${questions.size}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White, // biar kontras dengan background
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

            Spacer(modifier = Modifier.height(8.dp))


            // Progress bar (oranye = progress, track = biru-hijau)
            LinearProgressIndicator(
                progress = (currentIndex + 1) / questions.size.toFloat(),
                color = Color(0xFFFF7043),       // oranye
                trackColor = Color(0xFF4DB6AC),  // biru-hijau
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(45.dp))

            // Kotak pertanyaan (putih, rounded)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp)
                    .background(Color.White, shape = RoundedCornerShape(24.dp))
                    .padding(horizontal = 20.dp, vertical = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = question.question,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF7043),
                    textAlign = TextAlign.Center,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            // Jawaban: custom tombol dengan border & background sesuai status
            question.options.forEach { option ->
                val isCorrect = option == question.correctAnswer
                val isSelected = option == selectedAnswer

                val backgroundColor = when {
                    showAnswer && isCorrect -> Color(0xFF4CAF50)      // hijau jika jawaban benar
                    showAnswer && isSelected && !isCorrect -> Color(0xFFFF7043) // oranye jika salah & dipilih
                    else -> Color.Transparent
                }

                val borderColor = when {
                    showAnswer && isCorrect -> Color(0xFF4CAF50)
                    showAnswer && isSelected && !isCorrect -> Color(0xFFFF7043)
                    else -> Color(0xFF4DB6AC) // warna border default (biru muda)
                }

                Button(
                    onClick = {
                        if (!showAnswer) {
                            selectedAnswer = option
                            showAnswer = true
                            if (isCorrect) score++
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .heightIn(min = 56.dp)
                        .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(12.dp))
                ) {
                    // teks putih agar kontras saat border/transparent atau saat bg berwarna
                    Text(
                        text = option,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Feedback & tombol Next / Lihat Score
            if (showAnswer) {
                Text(
                    text = if (selectedAnswer == question.correctAnswer)
                        "Jawaban Kamu Benar!"
                    else
                        "Salah! Jawaban yang benar adalah: ${question.correctAnswer}",
                    color = if (selectedAnswer == question.correctAnswer) Color(0xFF4CAF50) else Color(0xFFF44336),
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        if (currentIndex < questions.lastIndex) {
                            currentIndex++
                            selectedAnswer = null
                            showAnswer = false
                        } else {
                            navController.navigate("result/${score}/${questions.size}")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = if (currentIndex < questions.lastIndex) "Soal Selanjutnya" else "Lihat Score"
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
