package com.example.animalcare.fragments_info


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.activities.GlideApp
import com.example.animalcare.database.entities.raza_entity
import kotlinx.android.synthetic.main.fragment_frag_info_perro.view.*

class frag_info_perro : Fragment() {
    lateinit var mascotaActual: raza_entity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mascotaActual = Constants.mascota!!
        val view = inflater.inflate(R.layout.fragment_frag_info_perro, container, false).apply {

            GlideApp.with(this)
                    .load(mascotaActual.img_raza)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(this.img_perro)

            this.tv_nombrePerro.text = mascotaActual.nombre_raza
            this.tv_origenPerro.text = mascotaActual.origen_raza
            this.tv_descripcionPerro.text = mascotaActual.descripcion_raza
            this.tv_peloPerro.text = mascotaActual.pelo_raza
            this.tv_aseoPerro.text = mascotaActual.aseo_raza
            this.tv_tamanoPerro.text = mascotaActual.tamanio_raza
            this.tv_ruidosoPerro.text = mascotaActual.ruidoso_raza
            this.tv_personalidadPerro.text = mascotaActual.personalidad_raza
            this.tv_saludPerro.text = mascotaActual.salud_raza
            this.tv_nutricionPerro.text = mascotaActual.nutricion_raza

        }



        return view
    }
}


