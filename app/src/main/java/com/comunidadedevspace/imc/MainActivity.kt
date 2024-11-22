package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // pega no XML e conecta com o MainActivity
        println(calculateIMC(80.0,1.75))
        println(calculateIMC(82.0,1.74))

        var imc: BigDecimal = BigDecimal(0)
        // Get back the introduced fields
        // create a variable and associate to the component de UI<EditText>
        val weightElement = findViewById<TextInputEditText>(R.id.weight)
        val heightElement = findViewById<TextInputEditText>(R.id.height)
        val submitElement = findViewById<Button>(R.id.submit)


        submitElement.setOnClickListener {
            val weight = weightElement.text
            val height = heightElement.text
            println(weight)
        }

        /*submit.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        imc = weight.text/(height.text*height.text);

                    }
                })*/
        /*fun submitClicked(view: View) {
            val submit = view as Button
            Log.i(weight + " weight" + height + "height")
        */



    }

    private fun calculateIMC(weight: Double, height: Double): Double {
        return weight/(height*height)
    }
}