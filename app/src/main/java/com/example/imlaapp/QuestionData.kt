package com.example.imlaapp

import com.example.imlaapp.model.Question

object QuestionData{
    val comprehensionQuestions = listOf(
        Question(
            question = "Pada kata اَلْمَسْجِدُ (al-masjidu), mengapa Lam (ل) dibaca dengan jelas (terang)?",
            options = listOf("Karena Mim (م) adalah salah satu huruf Qomariah.", "Karena Lam termasuk huruf yang tidak bisa disambung.", "Karena huruf Lam memiliki Tasydid."),
            correctAnswer = "Karena Mim (م) adalah salah satu huruf Qomariah."
        ),
        Question(
            question = "Saat menulis kata yang bunyinya diakhiri dengan Hamzah dan didahului oleh harakat Dhommah (bunyi 'u'),Hamzah harus ditulis di atas huruf apa?",
            options = listOf("Di atas Alif (أ)", "Di atas Wawu (ؤ)", "Sendirian di atas garis (ء)"),
            correctAnswer = "Di atas Wawu (ؤ)"
        ),
        Question(
            question = "Kata اَلنُّورُ (an-nuuru) dibaca dengan hukum Alif Lam Syamsiah. Huruf apa yang menjadi huruf Syamsiah pada kata tersebut?",
            options = listOf("Huruf Wawu (و)", "Huruf Ra' (ر)", "Huruf Nun (ن)"),
            correctAnswer = "Huruf Nun (ن)"
        ),
        Question(
            question = "Huruf Zay (ز) memiliki sifat yang sama dengan huruf Dal (د). Ini berarti huruf Zay (ز)...",
            options = listOf("Tidak dapat disambung sama sekali.", "Hanya dapat disambung ke huruf di sebelah kirinya (huruf setelahnya).", "Hanya dapat disambung dari huruf di sebelah kanannya (huruf sebelumnya)."),
            correctAnswer = "Hanya dapat disambung dari huruf di sebelah kanannya (huruf sebelumnya)."
        ),
        Question(
            question = "Manakah huruf yang paling mudah dikenali sebagai huruf yang tidak bisa disambung ke huruf setelahnya ?",
            options = listOf("Wawu (و)", "Ba' (ب)", "Jim (ج)"),
            correctAnswer = "Wawu (و)"
        ),
        Question(
            question = "Manakah kata berikut yang mengandung hukum bacaan Alif Lam Syamsiah?",
            options = listOf("اَلْغَنِيُّ (al-ghaniyyu)", "اَلزَّكَاةُ (az-zakaatu)", "اَلْكَبِيرُ (al-kabiiru)"),
            correctAnswer = "اَلزَّكَاةُ (az-zakaatu)"
        ),
        Question(
            question = "Manakah huruf berikut yang tidak boleh disambung ke huruf setelahnya?",
            options = listOf("Dzal (ذ)", "Sya' (ش)", "Mim (م)"),
            correctAnswer = "Dzal (ذ)"
        ),
        Question(
            question = "Jika sebuah kata adalah Alif Lam Syamsiah, maka huruf Lam (ل) pada Alif Lam tersebut akan dibaca?",
            options = listOf("Dilebur atau tidak dibaca.", "Jelas (izhar)", "Panjang (Mad)"),
            correctAnswer = "Dilebur atau tidak dibaca."
        ),
        Question(
            question = "Manakah dari huruf berikut yang menyebabkan Alif Lam menjadi Syamsiah?",
            options = listOf("Lam (ل)", "Kaf (ك)", "Ba' (ب)"),
            correctAnswer = "Lam (ل)"
        ),
        Question(
            question = "Kata اَلسَّلَامُ (as-salaamu) adalah bacaan Alif Lam Syamsiah. Tanda apa yang harus dimiliki huruf Sin (س) pada kata tersebut?",
            options = listOf("Tasydid (syaddah).", "Fathah saja.", "Dua harakat (tanwin)."),
            correctAnswer = "Tasydid (syaddah)."
        )
    )
}

