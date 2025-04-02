package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity


class primeiraTela : AppCompatActivity() {

   private lateinit var buttonT1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonT1 = findViewById(R.id.buttonT1)
        buttonT1.setOnClickListener{
                                    val intent = Intent(
                                    this,
                                    segundaTela::class.java
                                    )
            startActivity(intent)

        }
    }
}