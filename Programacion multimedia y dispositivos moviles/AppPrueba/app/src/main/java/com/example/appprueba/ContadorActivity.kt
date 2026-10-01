package com.example.appprueba

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContadorActivity : AppCompatActivity() {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        val tvValorContador = findViewById<TextView>(R.id.tvValorContador)
        val btnDecrementar = findViewById<Button>(R.id.btnDecrementar)
        val btnResetearContador = findViewById<Button>(R.id.btnResetearContador)
        val btnIncrementar = findViewById<Button>(R.id.btnIncrementar)
        val btnVolverDashboard2 = findViewById<Button>(R.id.btnVolverDashboard2)

        btnIncrementar.setOnClickListener {
            contador++
            tvValorContador.text = contador.toString()
        }

        btnDecrementar.setOnClickListener {
            contador--
            tvValorContador.text = contador.toString()
        }

        btnResetearContador.setOnClickListener {
            contador = 0
            tvValorContador.text = contador.toString()
        }

        btnVolverDashboard2.setOnClickListener {
            finish() // Cierra la pantalla y regresa al Dashboard
        }
    }
}