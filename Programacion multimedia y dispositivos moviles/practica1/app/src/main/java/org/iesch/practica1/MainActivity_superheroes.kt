package org.iesch.practica1

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practica1.databinding.ActivityMainSuperheroesBinding
import org.iesch.superheroes.model.SuperHeroe
import java.io.File

class MainActivity_superheroes : AppCompatActivity() {
    private lateinit var binding: ActivityMainSuperheroesBinding

    private lateinit var heroImage: ImageView
    private var heroBitMap: Bitmap? = null

    private var picturePath = ""

    private val getContent = registerForActivityResult(
        ActivityResultContracts.TakePicture()){
        success ->
            if (success && picturePath.isNotEmpty() ){
                heroBitMap = BitmapFactory.decodeFile(picturePath)
                heroImage.setImageBitmap(heroBitMap)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainSuperheroesBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonGuardar.setOnClickListener {

            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.ResumenBiografiaText.text.toString()
            val power = binding.miRatingBar.rating

            val superHeroe = SuperHeroe(superHeroName, alterEgo, bio, power)

            irADetailActivity(superHeroe)
        }

    }

    private fun crearImagenFile() : File {
        val fileName = "superhero_Image"
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)
        picturePath=imageFile.absolutePath;
        return imageFile
    }

    fun irADetailActivity(superHeroe: SuperHeroe) {
        var intent = Intent(this, DetailActivity_superheroes::class.java)

    }
}