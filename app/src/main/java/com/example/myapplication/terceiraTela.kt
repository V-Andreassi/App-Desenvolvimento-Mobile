package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class terceiraTela : AppCompatActivity() {

    private lateinit var buttonT4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_tela)

        buttonT4 = findViewById(R.id.buttonT4)
        buttonT4.setOnClickListener {
            val intent = Intent(this, segundaTela::class.java)
            startActivity(intent)
        }
    }
}