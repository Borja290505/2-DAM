package com.example.superheroes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.model.SuperHeroe
import kotlin.jvm.java

class SuperHeroeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usuario = intent.getStringExtra("usuario")
        binding.tvUsuario.text = getString(R.string.saludo, usuario)

        binding.btnSiguietne.setOnClickListener {
            val heroe = SuperHeroe(
                binding.editTextText.text.toString(),
                binding.editTextText2.text.toString(),
                binding.etBiografia.text.toString(),
                binding.rtSuperHeroe.rating
            )

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("superheroe",heroe)
            startActivity(intent)
        }

    }
}