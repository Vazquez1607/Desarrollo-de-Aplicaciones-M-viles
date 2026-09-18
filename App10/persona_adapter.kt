package com.example.app10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaAdapter(private val personas: List<Persona>) :
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvItemNombre)
        val tvPeso: TextView = view.findViewById(R.id.tvItemPeso)
        val tvAltura: TextView = view.findViewById(R.id.tvItemAltura)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(vista)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = personas[position]
        holder.tvNombre.text = "Nombre: ${persona.nombre}"
        holder.tvPeso.text = "Peso: ${persona.peso}"
        holder.tvAltura.text = "Altura: ${persona.altura}"
    }

    override fun getItemCount(): Int = personas.size
}