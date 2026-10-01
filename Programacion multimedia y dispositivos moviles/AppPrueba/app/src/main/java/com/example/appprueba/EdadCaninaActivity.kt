package com.example.appprueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EdadCaninaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edad_canina)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1 - Tomamos el control de los elementos de la UI
        val resultText = findViewById<TextView>(R.id.texto_respuesta)
        val calculateButton = findViewById<Button>(R.id.boton_calcular)
        val ageEdit = findViewById<EditText>(R.id.edit_edad)
        val btnVolverDashboard3 = findViewById<Button>(R.id.btnVolverDashboard3)

        // 2 - Configurar el evento onClick del botón de calcular
        calculateButton.setOnClickListener {
            val edadString = ageEdit.text.toString().trim()

            if (edadString.isEmpty()) {
                // 3 - Mostramos mensaje Toast si está vacío
                Toast.makeText(this, R.string.textoToast, Toast.LENGTH_LONG).show()
            } else {
                val edadInt = edadString.toInt()
                val dogAge = edadInt * 7

                resultText.text = getString(R.string.resultadotexto, dogAge)
            }
        }

        // 3 - Botón para volver al Dashboard
        btnVolverDashboard3.setOnClickListener {
            finish()
        }
    }
}