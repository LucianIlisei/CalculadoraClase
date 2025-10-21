package com.example.calculadoraclase

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtResultado: TextView
    private val calc: Calculadora = Calculadora.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById<TextView>(R.id.txtResultado)

        val botonesNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        val botonesOperaciones = listOf(
            R.id.btnSumar,
            R.id.btnRestar,
            R.id.btnMultiplicar,
            R.id.btnDividir
        )

        for (id in botonesNumeros) {
            val boton = findViewById<Button>(id)
            boton.setOnClickListener {
                val numero = boton.text.toString().toInt()
                calc.añadirNumero(numero)
                txtResultado.text = calc.contenido
            }
        }

        for (id in botonesOperaciones) {
            val boton = findViewById<Button>(id)
            boton.setOnClickListener {
                val operacion = boton.text.toString()[0]
                calc.operacion(operacion)
                txtResultado.text = ""
            }
        }

        val btnIgual = findViewById<Button>(R.id.btnIgual)
        btnIgual.setOnClickListener {
            calc.igual()
            txtResultado.text = calc.contenido
        }

        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        btnBorrar.setOnClickListener {
            calc.limpiar()
            txtResultado.text = "0"
        }

        val btnPunto = findViewById<Button>(R.id.btnPunto)
        btnPunto.setOnClickListener {
            calc.añadirPunto()
            txtResultado.text = calc.contenido
        }


    }

}