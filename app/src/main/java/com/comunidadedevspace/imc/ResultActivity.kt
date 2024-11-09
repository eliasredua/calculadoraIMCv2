package com.comunidadedevspace.imc

import android.os.Bundle
import android.view.TextureView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val (Classification, color) = when {
            result < 18.5f -> "MAGREZA" to R.color.red
            result > 18.5f && result <= 24.9f -> "NORMAL" to R.color.green
            result > 25f && result <= 29.9f -> "SOBREPESO" to R.color.yellow
            result > 30f && result <= 39.9f -> "OBESIDADE" to R.color.orange
            else -> "OBESIDADE GRAVE" to R.color.red
        }

        tvClassification.text = Classification
        tvClassification.setTextColor(ContextCompat.getColor(this, color))
    }
}