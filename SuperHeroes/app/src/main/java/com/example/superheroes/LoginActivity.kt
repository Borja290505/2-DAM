package com.example.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroes.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {

            val usuario = binding.etUsuario.text.toString()


            if (usuario.isNotEmpty()){
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("usuario", usuario)

                startActivity(intent)
            }else{
                Toast.makeText(this,"Debes rellenar los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}