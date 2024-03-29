package com.example.animalcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.database.entities.raza_entity
import kotlinx.android.synthetic.main.cardview_raza.view.*

lateinit var listaEspecie: ArrayList<raza_entity>

class RazaAdapter(var raza: MutableList<raza_entity>) :
        RecyclerView.Adapter<RazaAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(raza[position])



        if (Constants.especie == "perro") {
            holder.setItemClickListener(View.OnClickListener {
                Constants.mascota = raza[position]
                Navigation.findNavController(it).navigate(R.id.action_fragment_Animal_to_frag_info_perro)
            })
        } else {

            holder.setItemClickListener(View.OnClickListener {
                Constants.mascota = raza[position]
                Navigation.findNavController(it).navigate(R.id.action_fragment_Gato_to_frag_info_gato)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_raza, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return raza.size
    }

    fun updateList(newRaza: MutableList<raza_entity>) {
        newRaza.forEach {
            println("Nueva raza")
        }
        this.raza = newRaza
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItemClickListener(onClickListener: View.OnClickListener) {
            itemView.setOnClickListener { view -> onClickListener.onClick(view) }
        }


        fun bind(raza: raza_entity) = with(itemView) {
            Glide.with(this)
                    .load(raza.img_raza)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(iv_raza)

            this.tv_nombreRaza.text = raza.nombre_raza

        }
    }
}