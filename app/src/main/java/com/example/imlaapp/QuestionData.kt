package com.example.imlaapp

import com.example.imlaapp.model.Question

object QuestionData{
    val comprehensionQuestions = listOf(
        Question(
            question = "Apa nama harakat seperti garis miring di atas huruf?",
            options = listOf("Fathah", "Kasrah", "Dhammah"),
            correctAnswer = "Fathah"
        ),
        Question(
            question = "Harakat kasrah terletak di bagian?",
            options = listOf("Atas huruf", "Bawah huruf", "Samping huruf"),
            correctAnswer = "Bawah huruf"
        ),
        Question(
            question = "Sukun menandakan bahwa huruf harus?",
            options = listOf("Didengungkan", "Dibaca panjang", "Tidak dibaca harakatnya"),
            correctAnswer = "Tidak dibaca harakatnya"
        ),
        Question(
            question = "Dhammah menghasilkan bunyi?",
            options = listOf("I", "U", "A"),
            correctAnswer = "U"
        ),
        Question(
            question = "Huruf yang bertemu sukun dibaca?",
            options = listOf("Tanpa harakat", "Dengan harakat", "Dihilangkan"),
            correctAnswer = "Tanpa harakat"
        ),
        Question(
            question = "Bagaimana bentuk huruf Ba di awal kata?",
            options = listOf("بـ", "ـبـ", "ـب"),
            correctAnswer = "بـ"
        ),
        Question(
            question = "Bagaimana bentuk huruf Nun di tengah kata?",
            options = listOf("نـ", "ـنـ", "ـن"),
            correctAnswer = "ـنـ"
        ),
        Question(
            question = "Bagaimana bentuk huruf 'Ain di akhir kata?",
            options = listOf("عـ", "ـعـ", "ـع"),
            correctAnswer = "ـع"
        ),
        Question(
            question = "Huruf Jim di awal kata ditulis?",
            options = listOf("ـجـ", "ـج", "جـ"),
            correctAnswer = "جـ"
        ),
        Question(
            question = "Bentuk huruf Ya di tengah adalah?",
            options = listOf("ـيـ", "يـ", "ـي"),
            correctAnswer = "ـيـ"
        )
    )
}

