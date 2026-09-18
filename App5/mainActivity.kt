package com.example.app5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAceptar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val grupo = binding.etGrupo.text.toString()
            val correo = binding.etCorreo.text.toString()

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("NOMBRE", nombre)
            intent.putExtra("GRUPO", grupo)
            intent.putExtra("CORREO", correo)
            startActivity(intent)
        }
    }
}