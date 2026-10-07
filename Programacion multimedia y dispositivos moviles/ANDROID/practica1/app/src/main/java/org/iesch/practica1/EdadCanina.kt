package org.iesch.practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EdadCanina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.edad_canina)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textoRespuesta = findViewById<TextView>(R.id.TextoRespuesta)
        val botonCalcular = findViewById<Button>(R.id.BotonCalcular)
        val ageEdit = findViewById<EditText>(R.id.InputEdad)

        botonCalcular.setOnClickListener {
            if (!ageEdit.text.toString().isEmpty()){
                val edadString = ageEdit.text.toString()
                val edadInt = edadString.toInt()*7
                textoRespuesta.text = getString(R.string.textoRespuesta, edadInt)
            } else {
                Toast.makeText(this, R.string.texto_toast, Toast.LENGTH_SHORT).show()
            }
        }
    }
}