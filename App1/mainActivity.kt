package com.example.app1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    public lateinit var txtNombre: EditText
    public lateinit var txtGrupo: EditText
    public lateinit var txtCorreo: EditText
    public lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNombre = findViewById(R.id.editTextNombre)
        txtGrupo = findViewById(R.id.editTextGrupo)
        txtCorreo = findViewById(R.id.editTextCorreo)
        textview = findViewById(R.id.textView)

    }
    public fun mostrar(view: View){
        val nombre = txtNombre.text.toString()
        val grupo = txtGrupo.text.toString()
        val correo = txtCorreo.text.toString()
        val r = "nombre: " + nombre + "\nGrupo " + grupo + "\nCorreo: " + correo
        textview.text = r
    }
    public fun limpiar(view: View){
        txtNombre.setText("")
        txtGrupo.setText("")
        txtCorreo.setText("")
        textview.setText("")
    }
}