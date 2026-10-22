package com.example.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroes.databinding.ActivityPreguntaBinding

private lateinit var binding: ActivityPreguntaBinding
class PreguntaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle = intent.extras

        var arrayProgressText = arrayOf("1/3", "2/3", "3/3")

        var arrayPreguntaActual = arrayOf(
            "¿Que valor tiene Y en esta situación?",
            "¿Que valor tiene X en esta situación?",
            "¿Que valor tiene Z en esta situación?"
        )
        var arrayPreguntaActualExtra = arrayOf(
            "10 y = 70",
            "20 x = 10",
            "30 z = 150"
        )

        var arrayOpcion1 = arrayOf(
            "y = 7",
            "x = 1",
            "z = 15"
        )

        var arrayOpcion2 = arrayOf(
            "y = 70",
            "x = 0.5",
            "z = 5"
        )

        var arrayLogos = arrayOf(
            R.drawable.correct_icon,
            R.drawable.wrong_icon
        )

        var arrayAnswerGrande = arrayOf(
            "¡Correcto!",
            "¡Erroneo!"
        )

        var arrayAnswerPequeño = arrayOf(
            "Has elegido la respuesta correcta.",
            "Has elegido la respuesta incorrecta."
        )

        var preguntaActual = bundle?.getInt("numeroPregunta") ?: 1
        var opcionEscogida = 0

        if(preguntaActual==1){
            binding.tvNumero.text = arrayProgressText[0]
            binding.progressBar.progress = 33
            binding.preguntaActual.text = arrayPreguntaActual[0]
            binding.radioButton1.text = arrayOpcion1[0]
            binding.radioButton2.text = arrayOpcion2[0]
        }

        if(preguntaActual==1){
            binding.tvNumero.text = arrayProgressText[1]
            binding.progressBar.progress = 33
            binding.preguntaActual.text = arrayPreguntaActual[1]
            binding.radioButton1.text = arrayOpcion1[1]
            binding.radioButton2.text = arrayOpcion2[1]
        }

        if(preguntaActual==1){
            binding.tvNumero.text = arrayProgressText[2]
            binding.progressBar.progress = 33
            binding.preguntaActual.text = arrayPreguntaActual[2]
            binding.radioButton1.text = arrayOpcion1[2]
            binding.radioButton2.text = arrayOpcion2[2]
        }

        binding.radioGroup.setOnCheckedChangeListener { group, i ->
            when(i){
                binding.radioButton1.id -> {
                    opcionEscogida = 1
                }
                binding.radioButton2.id -> {
                    opcionEscogida = 2
                }
            }
        }

        var numeroAciertos = bundle?.getInt("numeroAciertos") ?: 0

        var intentParaElQuizz = Intent(this, SolucionActivity::class.java)
        binding.button.setOnClickListener {
            if(preguntaActual == 1){
                if(opcionEscogida == 0){
                    Toast.makeText(this,"Debes elegir una opcion", Toast.LENGTH_SHORT).show()
                }else{
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                }

            }
            if (preguntaActual == 2) {

                if (opcionEscogida == 0) {
                    Toast.makeText(this, "Porfavor Selecciona una opción", Toast.LENGTH_SHORT).show()

                } else {
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        startActivity(intentParaElQuizz)
                    }
                }

            }

            if (preguntaActual == 3) {

                if (opcionEscogida == 0) {
                    Toast.makeText(this, "Porfavor Selecciona una opción", Toast.LENGTH_SHORT).show()

                } else {
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                }
            }
        }
    }
}