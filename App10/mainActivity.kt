package com.example.app10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val peso = binding.etPeso.text.toString()
            val altura = binding.etAltura.text.toString()

            if (nombre.isNotEmpty() && peso.isNotEmpty() && altura.isNotEmpty()) {
                DatosPersonas.lista.add(Persona(nombre, peso, altura))

                // Limpiar campos para agregar otra persona si quiere
                binding.etNombre.text.clear()
                binding.etPeso.text.clear()
                binding.etAltura.text.clear()

                val intent = Intent(this, SegundaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}