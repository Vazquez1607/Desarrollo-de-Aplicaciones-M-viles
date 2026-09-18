package com.example.app4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            calcularOperaciones()
        }
    }

    private fun calcularOperaciones() {
        val texto1 = binding.etNumero1.text.toString()
        val texto2 = binding.etNumero2.text.toString()

        if (texto1.isEmpty() || texto2.isEmpty()) {
            binding.tvResultados.text = "Por favor ingresa ambos números."
            return
        }

        val num1 = texto1.toDouble()
        val num2 = texto2.toDouble()

        val suma = num1 + num2
        val resta = num1 - num2
        val multiplicacion = num1 * num2
        val division = if (num2 != 0.0) (num1 / num2).toString() else "No se puede dividir entre 0"

        binding.tvResultados.text = """
            Suma: $suma
            Resta: $resta
            Multiplicación: $multiplicacion
            División: $division
        """.trimIndent()
    }
}