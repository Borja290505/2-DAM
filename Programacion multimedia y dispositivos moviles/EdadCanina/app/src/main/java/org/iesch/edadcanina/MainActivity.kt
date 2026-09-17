package org.iesch.edadcanina

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Aquí la pantalla está creada.

        // 1 - Tomamos el control de todos los elementos de la parte de la UI
        val resultText = findViewById<TextView>(R.id.texto_respuesta)
        val calculateButton = findViewById<Button>(R.id.boton_calcular)
        val ageEdit = findViewById<EditText>(R.id.edit_edad)

        // 2 - Los botones tiene las propiedad setOnClickListener al pulsarlo
        calculateButton.setOnClickListener {
            // Aqui metemos el codigo de lo que queremos hace cuando pulsemos el boton
            val edadString = ageEdit.text.toString()

            //Para comprobar si esta vacio
            if ( edadString.isEmpty() ){
                // 3 - Mostramos un mensaje de tipo Toast
                Toast.makeText(this,R.string.textoToast, Toast.LENGTH_LONG).show()
            }else{
                //Necesitmos pasar el numero entero
                val edadInt = edadString.toInt()
                val dogAge = edadInt * 7

                resultText.text = getString(R.string.resultadotexto, dogAge)
            }
        }
    }
}