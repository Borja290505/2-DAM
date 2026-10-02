package com.example.appprueba

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appprueba.databinding.ActivitySuperheroDetailBinding

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperheroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        val superHeroName = bundle?.getString("superHeroName") ?: "No hay nombre"
        val alterEgo = bundle?.getString("alterEgo") ?: "No hay AlterEgo"
        val bio = bundle?.getString("bio") ?: "No hay bio"
        val power = bundle?.getFloat("power") ?: 0f

        binding.heroNameTv.text = superHeroName
        binding.alterEgoResult.text = alterEgo
        binding.bioResult.text = bio
        binding.ratingBar2.rating = power

        binding.btnVolverDashboard4.setOnClickListener {
            finish()
        }
    }
}