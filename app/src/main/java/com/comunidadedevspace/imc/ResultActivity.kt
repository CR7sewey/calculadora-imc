package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_IMC = "imc"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // elements
        val tv_result = findViewById<TextView>(R.id.tv_result)
        val tv_classification = findViewById<TextView>(R.id.tv_classification)
        val backButton = findViewById<TextView>(R.id.button)


        // atribute values
        var imc: String? = intent.getStringExtra(KEY_IMC)
        tv_result.text = imc

        if (imc.isNullOrBlank()) {
            imc = "0.00"
        }

        if (imc.toDouble().compareTo(18.5) <= 0) {
            tv_classification.text = "Magro"
            tv_classification.setTextColor(getResources().getColor(R.color.magroColor))
        }
        else if (imc.toDouble() <= 24.9) {
            tv_classification.text= "Normal"
            tv_classification.setTextColor(getResources().getColor(R.color.normalColor))
        }
        else if (imc.toDouble() >24.9 && imc.toDouble() <= 29.9) {
                tv_classification.text= "Acima"
            tv_classification.setTextColor(getResources().getColor(R.color.acimaColor))

        }
        else if (imc.toDouble().compareTo(39.9) <= 0) {
            tv_classification.text= "Obesidade"
            tv_classification.setTextColor(getResources().getColor(R.color.obesidadeColor))

        }
        else {
            tv_classification.text= "Obesidade Morbida"
            tv_classification.setTextColor(getResources().getColor(R.color.obesidadeMorbida))

        }
        println(tv_classification.text)


        backButton.setOnClickListener {
            val explicitIntent = Intent(this, MainActivity::class.java)
            startActivity(explicitIntent)
        }



    }
}