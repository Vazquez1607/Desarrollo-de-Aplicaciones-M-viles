package com.example.app9

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Nombre de la ubicación -> texto para buscar en Maps
    private val ubicaciones = listOf("Llano de la cruz", "Mazatlán", "Acaponeta" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ubicaciones)
        binding.spinnerUbicacion.adapter = adapter

        // Botón teléfono: abre la app de teléfono con el número puesto
        binding.btnTelefono.setOnClickListener {
            val numero = binding.etTelefono.text.toString()
            if (numero.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$numero")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Escribe un número primero", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón YouTube: abre el link en la app/navegador
        binding.btnYoutube.setOnClickListener {
            val link = binding.etYoutube.text.toString()
            if (link.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Escribe un enlace primero", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón ubicación: abre Maps con la ubicación elegida
        binding.btnUbicacion.setOnClickListener {
            val lugar = binding.spinnerUbicacion.selectedItem.toString()
            val uri = Uri.parse("geo:0,0?q=${Uri.encode(lugar)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}