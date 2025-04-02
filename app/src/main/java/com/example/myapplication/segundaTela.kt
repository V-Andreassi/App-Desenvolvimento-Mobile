package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class segundaTela : AppCompatActivity() {

    private lateinit var buttonVoltar: Button
    private lateinit var buttonProxima: Button
    private lateinit var notaEditText: EditText
    private lateinit var calcularButton: Button
    private lateinit var resultadoTextView: TextView
    private lateinit var imagemReprovado: ImageView
    private lateinit var imagemProvaSub: ImageView
    private lateinit var imagemAprovado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonVoltar = findViewById(R.id.buttonVoltar)
        buttonProxima = findViewById(R.id.buttonProxima)
        notaEditText = findViewById(R.id.notaEditText)
        calcularButton = findViewById(R.id.calcularButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)
        imagemReprovado = findViewById(R.id.imagemReprovado)
        imagemProvaSub = findViewById(R.id.imagemProvaSub)
        imagemAprovado = findViewById(R.id.imagemAprovado)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, primeiraTela::class.java)
            startActivity(intent)
            finish()
        }

        buttonProxima.setOnClickListener {
            val intent = Intent(this, terceiraTela::class.java)
            startActivity(intent)
        }

        calcularButton.setOnClickListener {
            val nota = notaEditText.text.toString().toDoubleOrNull() ?: 0.0
            val resultado = verificarAprovacao(nota)
            resultadoTextView.text = resultado


            imagemReprovado.visibility = View.GONE
            imagemProvaSub.visibility = View.GONE
            imagemAprovado.visibility = View.GONE


            when (resultado) {
                "Reprovado" -> imagemReprovado.visibility = View.VISIBLE
                "Prova sub" -> imagemProvaSub.visibility = View.VISIBLE
                "Aprovado" -> imagemAprovado.visibility = View.VISIBLE
            }
        }
    }

    fun verificarAprovacao(nota: Double): String {
        return when {
            nota < 4 -> "Reprovado"
            nota >= 4 && nota < 6 -> "Prova sub"
            else -> "Aprovado"
        }
    }
}