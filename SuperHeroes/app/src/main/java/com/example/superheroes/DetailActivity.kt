package com.example.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroes.databinding.ActivityDetailBinding
import com.example.superheroes.model.SuperHeroe

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val superHeroe = if ( android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU ){
            intent.getParcelableExtra("superheroe", SuperHeroe::class.java)
        } else {
            intent.getParcelableExtra<SuperHeroe>("superheroe")
        }

        binding.heroNameTv.text = superHeroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superHeroe?.alterEgo ?: "No hay AlterEgo"
        binding.bioResult.text = superHeroe?.bio ?: "No hay bio"
        binding.ratingResult.rating = superHeroe?.power ?: 0f

    }
}