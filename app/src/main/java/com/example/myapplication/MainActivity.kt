package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.font.Font

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var backButton: Button
    private lateinit var nextButton: Button

    private val imageIds = arrayOf(
        R.drawable.bajigur,
        R.drawable.bandrek,
        R.drawable.es_cendol,
        R.drawable.jamu,
        R.drawable.sekoteng
    )

    private val descriptions = arrayOf(
        "Bajigur adalah minuman tradisional yang terbuat dari bahan baku jahe. Lalu, ditambahkan dengan gula aren dan santan.",
        "Bandrek adalah jenis minuman hangat yang terbuat dari beberapa rempah-rempah.",
        "Es cendol adalah salah satu jenis minuman khas Indonesia yang digemari banyak orang dan telah mendunia.",
        "Jamu adalah minuman khas Indonesia yang sudah turun temurun diwariskan dari nenek moyang.",
        "Sekoteng adalah minuman khas Indonesia yang berasal dari Jawa Tengah. Minuman hangat yang berbahan dasar jahe ini mampu memberikan tekstur yang kaya ketika disantap."
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
            gravity = android.view.Gravity.CENTER
        }

        imageView = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(600, 600).apply {
            }
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        descriptionTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            text = descriptions[currentIndex]
            textSize = 18f
            gravity = android.view.Gravity.CENTER
        }

        val buttonLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = android.view.Gravity.CENTER
        }

        backButton = Button(this).apply {
            text = "Kembali"
            setOnClickListener {
                if (currentIndex > 0) {
                    currentIndex--
                    updateImageAndDescription()
                }
            }
        }

        nextButton = Button(this).apply {
            text = "Selanjutnya"
            setOnClickListener {
                if (currentIndex < imageIds.size - 1) {
                    currentIndex++
                    updateImageAndDescription()
                }
            }
        }

        buttonLayout.addView(backButton)
        buttonLayout.addView(nextButton)

        layout.addView(imageView)
        layout.addView(descriptionTextView)
        layout.addView(buttonLayout)

        setContentView(layout)

        updateImageAndDescription()
    }

    private fun updateImageAndDescription() {
        imageView.setImageResource(imageIds[currentIndex])
        descriptionTextView.text = descriptions[currentIndex]
    }
}
