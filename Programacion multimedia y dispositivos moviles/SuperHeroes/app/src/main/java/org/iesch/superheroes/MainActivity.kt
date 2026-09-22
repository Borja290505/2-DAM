package org.iesch.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // A partir de aqui introduzco el codigo necesario
        val botonGuardar = findViewById<Button>(R.id.Boton_guardar)

        botonGuardar.setOnClickListener {
            // Obtenemos lo valores al hacer click
            val superHeroName = findViewById<EditText>(R.id.hero_edit_name).text.toString()
            val alterEgoEdit = findViewById<EditText>(R.id.alter_ego_edit).text.toString()
            val bio = findViewById<EditText>(R.id.bio_edit).text.toString()
            val power = findViewById<RatingBar>(R.id.power).rating


            // Que quiero hacer cuando pulso el boton guardar
            irADetailActivity(superHeroName,alterEgoEdit,bio,power)
        }
    }

    fun irADetailActivity(superHeroName: String, alterEgoEdit: String, bio: String, power: Float) {
        //Creamos el objeto
        val intent = Intent(this, DetailsActivity::class.java)

        //Añadimos todos los campos con el metodo putExtra
        intent.putExtra("superHeroName",superHeroName)
        intent.putExtra("alterEgoEdit",alterEgoEdit)
        intent.putExtra("bio",bio)
        intent.putExtra("power",power)

        //Todos los datos se enviaran al DetailActivity
        //Iniciamos la nueva actividad
        startActivity(intent)
    }
}