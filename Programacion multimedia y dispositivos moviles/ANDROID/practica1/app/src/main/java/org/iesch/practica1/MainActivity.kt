package org.iesch.practica1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.iesch.practica1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("usuario")

        binding.buenosDias.text = ("Hola, " + (usuario)?.ifEmpty {"Usuario Sin nombre" })

        binding.layoutEdadCanina.setOnClickListener {
            startActivity(Intent(this, EdadCanina::class.java))
        }

        binding.layoutSuperHeroes.setOnClickListener {
            startActivity(Intent(this, MainActivity_superheroes::class.java))
        }
    }
}
