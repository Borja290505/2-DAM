package com.example.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroes.databinding.ActivityLoginBinding
import com.example.superheroes.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        binding.btnEntrar.setOnClickListener {
            val usuario = binding.etUsuario.text.toString().trim()
            val contrasenia = binding.etContrasena.text.toString().trim()

            if (usuario.isNotEmpty() && contrasenia.isNotEmpty()){

                val siguienteActividad = Intent(this, MainActivity::class.java).apply {
                    putExtra("usuario", usuario)
                }

                startActivity(siguienteActividad)
            }else{
                Toast.makeText(this,"Debes rellenar los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}