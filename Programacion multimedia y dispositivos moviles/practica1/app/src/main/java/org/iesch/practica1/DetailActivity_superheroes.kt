package org.iesch.practica1

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practica1.R
import org.iesch.practica1.databinding.ActivityDetailSuperheroesBinding
import org.iesch.superheroes.model.SuperHeroe

class DetailActivity_superheroes : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailSuperheroesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!

        val bitmapDirectory = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitmapDirectory)

        binding.imagenSuperHeroe.setImageBitmap(bitmap)

    }
}