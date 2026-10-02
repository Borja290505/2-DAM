package com.example.appprueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val tvResultadoCalc = findViewById<TextView>(R.id.tvResultadoCalc)
        val btnVolverDashboard1 = findViewById<Button>(R.id.btnVolverDashboard1)

        fun calcular(operacion: (Double, Double) -> Double) {
            val num1Str = etNum1.text.toString()
            val num2Str = etNum2.text.toString()

            if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
                val n1 = num1Str.toDouble()
                val n2 = num2Str.toDouble()
                val res = operacion(n1, n2)
                tvResultadoCalc.text = "Resultado: $res"
            } else {
                Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show()
            }
        }

        btnSumar.setOnClickListener { calcular { a, b -> a + b } }
        btnRestar.setOnClickListener { calcular { a, b -> a - b } }
        btnMultiplicar.setOnClickListener { calcular { a, b -> a * b } }
        btnDividir.setOnClickListener {
            val num2Str = etNum2.text.toString()
            if (num2Str == "0" || num2Str == "0.0") {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
            } else {
                calcular { a, b -> a / b }
            }
        }

        btnVolverDashboard1.setOnClickListener {
            finish() // Cierra la pantalla y regresa al Dashboard
        }
    }
}