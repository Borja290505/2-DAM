package com.example.superheroes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroes.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usuario = intent.getStringExtra("usuario")
        val nombre = if(usuario.isNullOrEmpty()){
            getString(R.string.nombre_usuario)
        }else{
            usuario
        }
        binding.tvUsuario.text = getString(R.string.bienvenido,nombre)

        binding.btnSiguietne.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }

    }
}