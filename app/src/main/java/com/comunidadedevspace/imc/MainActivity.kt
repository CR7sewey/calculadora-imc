package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal
import java.math.RoundingMode



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // pega no XML e conecta com o MainActivity
        //println(calculateIMC(80.0,1.75))
       // println(calculateIMC(82.0,1.74))

        // Get back the introduced fields
        // create a variable and associate to the component de UI<EditText>
        val weightElement = findViewById<TextInputEditText>(R.id.weight)
        val heightElement = findViewById<TextInputEditText>(R.id.height)
        val submitElement = findViewById<Button>(R.id.submit)
        // val result = findViewById<TextView>(R.id.result)


        submitElement.setOnClickListener {
            var imc: String;
            val weightStr: String = weightElement.text.toString()
            val heightStr: String = heightElement.text.toString()
            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Snackbar.make(heightElement, "Please, insert a valid value!", Snackbar.LENGTH_LONG).show()
            }
            else {
                val weight: Double = weightStr.toDouble()
                val height: Double = heightStr.toDouble()
                imc = calculateIMC(weight, height)

                // Navigate to Next Activity aka screen
                // New screen layout
                // pass dat to new screen

                // Intent - Classe do proprio android (declarar intencoes que queremos fazer - intent implicita (nao especifica componente, mas sim acao) e explicita (especifica componente) - ver ChatGPT)
                val explicitIntent: Intent = Intent(this, ResultActivity::class.java) // atual e proxima
                explicitIntent.putExtra(KEY_IMC,imc)
                startActivity(explicitIntent)

            }
        }
    }

    private fun calculateIMC(weight: Double, height: Double): String {
        val imc: Double = weight / (Math.pow(height, 2.0))
        val imcRounded = BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN)
        return imcRounded.toString()
    }



}