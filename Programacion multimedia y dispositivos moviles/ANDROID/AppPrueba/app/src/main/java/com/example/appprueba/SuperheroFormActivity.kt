package com.example.appprueba

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appprueba.databinding.ActivitySuperheroFormBinding

class SuperheroFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperheroFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.BotonGuardar.setOnClickListener {
            val superHeroName = binding.heroEditName.text.toString()
            val alterEgoEdit = binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.power.rating

            irADetailActivity(superHeroName, alterEgoEdit, bio, power)
        }

        binding.BotonVolver.setOnClickListener{
            finish()
        }
    }

    private fun irADetailActivity(superHeroName: String, alterEgo: String, bio: String, power: Float) {
        val intent = Intent(this, SuperheroDetailActivity::class.java)
        intent.putExtra("superHeroName", superHeroName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        startActivity(intent)
    }
}