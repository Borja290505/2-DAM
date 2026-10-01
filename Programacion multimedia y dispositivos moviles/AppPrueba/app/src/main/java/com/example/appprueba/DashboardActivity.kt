package com.example.appprueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnAbrirApp1 = findViewById<Button>(R.id.btnAbrirApp1)
        val btnAbrirApp2 = findViewById<Button>(R.id.btnAbrirApp2)
        val btnAbrirApp3 = findViewById<Button>(R.id.btnAbrirApp3)
        val btnAbrirApp4 = findViewById<Button>(R.id.btnAbrirApp4)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        btnAbrirApp1.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        btnAbrirApp2.setOnClickListener {
            val intent = Intent(this, ContadorActivity::class.java)
            startActivity(intent)
        }

        btnAbrirApp3.setOnClickListener {
            val intent = Intent(this, EdadCaninaActivity::class.java)
            startActivity(intent)
        }

        btnAbrirApp4.setOnClickListener {
            val intent = Intent(this, SuperheroFormActivity::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}