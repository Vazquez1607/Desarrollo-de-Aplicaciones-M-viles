package com.example.app7

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.app7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val compuertas = listOf("AND", "OR", "NOT", "NAND")
    private val valoresA = listOf(0, 0, 1, 1)
    private val valoresB = listOf(0, 1, 0, 1)

    private var compuertaActual = "AND"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, compuertas)
        binding.spinnerCompuerta.adapter = adapter

        binding.spinnerCompuerta.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                compuertaActual = compuertas[position]
                binding.tvCompuertaNombre.text = compuertaActual

                // Si es NOT, ocultamos el checkbox B (solo tiene una entrada)
                binding.checkB.visibility = if (compuertaActual == "NOT") View.GONE else View.VISIBLE

                mostrarTabla(compuertaActual)
                actualizarSalida()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.checkA.setOnCheckedChangeListener { _, _ -> actualizarSalida() }
        binding.checkB.setOnCheckedChangeListener { _, _ -> actualizarSalida() }

        mostrarTabla(compuertaActual)
        actualizarSalida()
    }

    private fun calcularZ(compuerta: String, a: Int, b: Int): Int {
        return when (compuerta) {
            "AND" -> a and b
            "OR" -> a or b
            "NOT" -> if (a == 1) 0 else 1
            "NAND" -> if (a and b == 1) 0 else 1
            else -> 0
        }
    }

    private fun actualizarSalida() {
        val a = if (binding.checkA.isChecked) 1 else 0
        val b = if (binding.checkB.isChecked) 1 else 0
        val z = calcularZ(compuertaActual, a, b)

        val drawable = binding.circuloSalida.background as GradientDrawable
        drawable.setColor(if (z == 1) 0xFF4CAF50.toInt() else 0xFFCCCCCC.toInt())
    }

    private fun mostrarTabla(compuerta: String) {
        val tvA = listOf(binding.tvA1, binding.tvA2, binding.tvA3, binding.tvA4)
        val tvB = listOf(binding.tvB1, binding.tvB2, binding.tvB3, binding.tvB4)
        val tvZ = listOf(binding.tvZ1, binding.tvZ2, binding.tvZ3, binding.tvZ4)

        if (compuerta == "NOT") {
            // NOT solo tiene 2 combinaciones posibles: A=0 y A=1
            val valoresNotA = listOf(0, 1)
            for (i in 0..3) {
                if (i < 2) {
                    val a = valoresNotA[i]
                    tvA[i].text = a.toString()
                    tvB[i].text = "-"
                    tvZ[i].text = calcularZ(compuerta, a, 0).toString()
                } else {
                    // Filas extra se dejan vacías
                    tvA[i].text = ""
                    tvB[i].text = ""
                    tvZ[i].text = ""
                }
            }
        } else {
            for (i in 0..3) {
                val a = valoresA[i]
                val b = valoresB[i]
                val z = calcularZ(compuerta, a, b)

                tvA[i].text = a.toString()
                tvB[i].text = b.toString()
                tvZ[i].text = z.toString()
            }
        }
    }
}