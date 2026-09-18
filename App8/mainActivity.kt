package com.example.app8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMostrar.setOnClickListener {
            mostrarTabla()
        }
    }

    private fun mostrarTabla() {
        val texto = binding.etNumero.text.toString()
        val numero = texto.toIntOrNull()

        // Si no es un número válido o está fuera de 1-12, no hace nada
        if (numero == null || numero < 1 || numero > 12) {
            return
        }

        val resultado = StringBuilder()

        for (i in 1..12) {
            resultado.append("$numero x $i = ${numero * i}\n")
        }

        binding.tvTabla.text = resultado.toString()
    }
}