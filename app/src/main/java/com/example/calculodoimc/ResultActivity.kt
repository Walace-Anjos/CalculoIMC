package com.example.calculodoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val TvResult: TextView = findViewById(R.id.Tv_result)
        val TvClassificacao: TextView = findViewById(R.id.Tv_Classificacao)
        val Result =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        TvResult.text = Result.toString()

        val Classificacao = if (Result < 18.5f) {
            "ABAIXO DO PESO"
        }else if (Result in 18.5f..24.9f) {
            "NORMAL"
        }else if (Result in 24.9f..29.9f) {
            "SOBREPESO"
        }else if (Result in 29.9f..39.9f) {
            "OBESIDADE"
        }else {
            "OBESIDADE GRAVE"
        }

        TvClassificacao.text = getString(R.string.messsage_Classificacao, Classificacao)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}