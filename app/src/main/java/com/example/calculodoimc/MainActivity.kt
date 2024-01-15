package com.example.calculodoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btn_Calcular)
        val EdtAltura: EditText = findViewById(R.id.edt_altura)
        val EdtPeso: EditText = findViewById(R.id.edt_peso)

        btnCalcular.setOnClickListener {

            val AlturaStr = EdtAltura.text.toString()
            val PesoStr = EdtPeso.text.toString()

            if (AlturaStr.isNotEmpty() && PesoStr.isNotEmpty()) {
                val Altura: Float = AlturaStr.toFloat()
                val Peso: Float = PesoStr.toFloat()

                val AlturaFinal: Float = Altura * Altura
                val Resultado: Float = Peso / AlturaFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", Resultado)
                    }
                startActivity(intent)

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }

        }
    }    }