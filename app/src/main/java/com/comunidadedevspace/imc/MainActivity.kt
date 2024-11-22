package com.comunidadedevspace.imc

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
        val result = findViewById<TextView>(R.id.result)


        submitElement.setOnClickListener {
            var imc: String;
            val weightStr: String = weightElement.text.toString()
            val heightStr: String = heightElement.text.toString()
            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Snackbar.make(result, "Please, insert a valid value!", Snackbar.LENGTH_LONG).show()
            }
            else {
                val weight: Double = weightStr.toDouble()
                val height: Double = heightStr.toDouble()
                imc = calculateIMC(weight, height)
                result.text = imc
                result.visibility = View.VISIBLE
            }

            /*try {
                val weight: Double = weightElement.text.toString().toDouble()
                val height: Double = heightElement.text.toString().toDouble()
                imc = calculateIMC(weight, height)
           // }
           // catch (e: Error) {
              //  imc = "Please, insert a valid value!"
             //   println(e.message)
            //}*/

            //result.text = imc
            //result.visibility = View.VISIBLE
            //println(weight)
        }

        /*submit.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        imc = weight.text/(height.text*height.text);

                    }
                })*/
    }

    private fun calculateIMC(weight: Double, height: Double): String {
        val imc: Double = weight / (Math.pow(height, 2.0))
        val imcRounded = BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN)
        return imcRounded.toString()
    }



}