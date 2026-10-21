package com.example.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroes.databinding.ActivityDetailBinding
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.model.SuperHeroe

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superHeroe = if ( android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU ){
            intent.getParcelableExtra("superHero", SuperHeroe::class.java)
        } else {
            intent.getParcelableExtra<SuperHeroe>("superHero")
        }

        val bundle = intent.extras!!

        binding.heroNameTv.text = superHeroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superHeroe?.alterEgo ?: "No hay AlterEgo"
        binding.bioResult.text = superHeroe?.bio ?: "No hay bio"
        binding.ratingResult.rating = superHeroe?.power ?: 0f

    }
}