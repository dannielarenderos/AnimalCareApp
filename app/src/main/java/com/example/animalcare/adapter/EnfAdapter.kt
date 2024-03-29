package com.example.animalcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.database.entities.enfermedad_entity
import kotlinx.android.synthetic.main.cardview_enfermedades.view.*


class EnfAdapter(var enfermedades: List<enfermedad_entity>) : RecyclerView.Adapter<EnfAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_enfermedades, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return enfermedades.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(enfermedades[position])
        holder.setItemClickListener(View.OnClickListener {
            Constants.Enfermedad = enfermedades[position]
            Navigation.findNavController(it).navigate(R.id.action_fragment_enfermedades_to_frag_info_enf)
        })
    }

    fun updateList(newEnfermedad: List<enfermedad_entity>) {
        newEnfermedad.forEach {
            println("Nueva Enfermedad")
        }
        this.enfermedades = newEnfermedad
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setItemClickListener(onClickListener: View.OnClickListener) {
            itemView.setOnClickListener { view -> onClickListener.onClick(view) }
        }

        fun bind(enfermedad: enfermedad_entity) = with(itemView) {

            this.tv_nomEnf.text = enfermedad.nombre_enf
            this.tv_tipoEnf.text = enfermedad.tipo_enf
            this.tv_especieEnf.text = enfermedad.especia_enf
        }
    }
}
