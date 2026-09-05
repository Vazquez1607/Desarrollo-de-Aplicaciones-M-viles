package com.example.app0

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.abs
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Campos para ingresar a, b y c
        val txtA = findViewById<EditText>(R.id.editTextText4)
        val txtB = findViewById<EditText>(R.id.editTextText2)
        val txtC = findViewById<EditText>(R.id.editTextText5)

        // Resultados
        val txtX1 = findViewById<TextView>(R.id.txtX1)
        val txtX2 = findViewById<TextView>(R.id.txtX2)

        // Botones
        val btnCalcular = findViewById<Button>(R.id.button)
        val btnLimpiar = findViewById<Button>(R.id.button2)

        // Botón CALCULAR
        btnCalcular.setOnClickListener {

            try {

                val a = txtA.text.toString().toDouble()
                val b = txtB.text.toString().toDouble()
                val c = txtC.text.toString().toDouble()

                // Verificar que sea una ecuación cuadrática
                if (a == 0.0) {
                    txtX1.text = "x₁ = El valor de a no puede ser 0"
                    txtX2.text = "x₂ ="
                    return@setOnClickListener
                }

                // Fórmula del discriminante
                val discriminante = (b * b) - (4 * a * c)

                if (discriminante > 0) {

                    // Dos raíces reales diferentes
                    val x1 = (-b + sqrt(discriminante)) / (2 * a)
                    val x2 = (-b - sqrt(discriminante)) / (2 * a)

                    txtX1.text = "x₁ = $x1"
                    txtX2.text = "x₂ = $x2"

                } else if (abs(discriminante) < 0.0000001) {

                    // Una raíz real repetida
                    val x = -b / (2 * a)

                    txtX1.text = "x₁ = $x"
                    txtX2.text = "x₂ = $x"

                } else {

                    // Raíces complejas
                    val parteReal = -b / (2 * a)
                    val parteImaginaria =
                        sqrt(-discriminante) / abs(2 * a)

                    txtX1.text =
                        "x₁ = $parteReal + ${parteImaginaria}i"

                    txtX2.text =
                        "x₂ = $parteReal - ${parteImaginaria}i"
                }

            } catch (e: Exception) {

                txtX1.text = "x₁ = Ingresa valores válidos"
                txtX2.text = "x₂ ="
            }
        }

        // Botón LIMPIAR
        btnLimpiar.setOnClickListener {

            txtA.text.clear()
            txtB.text.clear()
            txtC.text.clear()

            txtX1.text = "x₁ ="
            txtX2.text = "x₂ ="

            txtA.requestFocus()
        }

        // Ajuste de pantalla
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}