package com.example.animalcare.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.activities.GlideApp
import com.example.animalcare.database.entities.enfermedad_entity
import com.example.animalcare.database.entities.vet_entity
import kotlinx.android.synthetic.main.fragment_frag_info_enf.view.*


class frag_info_enf : Fragment() {

    lateinit var enfermedadActual : enfermedad_entity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        enfermedadActual = Constants.Enfermedad!!
        val view = inflater.inflate(R.layout.fragment_frag_info_enf, container, false).apply {

            this.tv_nomEnf.text = enfermedadActual.nombre_enf
            this.tv_tipoenf.text = enfermedadActual.tipo_enf
            this.tv_especieEnf.text = enfermedadActual.especia_enf
            this.tv_sintomaEnf.text = enfermedadActual.sintomas_enf
            this.tv_tratEnf.text = enfermedadActual.tratamiento_enf

        }



        return view
    }


}
