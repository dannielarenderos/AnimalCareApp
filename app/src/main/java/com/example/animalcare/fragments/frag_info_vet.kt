package com.example.animalcare.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.activities.GlideApp
import com.example.animalcare.database.entities.vet_entity
import kotlinx.android.synthetic.main.cardview_vet.view.*
import kotlinx.android.synthetic.main.cardview_vet.view.img_vet
import kotlinx.android.synthetic.main.fragment_frag_info_vet.*
import kotlinx.android.synthetic.main.fragment_frag_info_vet.view.*





class frag_info_vet : Fragment() {

    lateinit var veterinariaActual : vet_entity




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        veterinariaActual = Constants.veterinaria!!
        val view = inflater.inflate(R.layout.fragment_frag_info_vet, container, false).apply {

            GlideApp.with(this)
                .load(veterinariaActual.img_vet)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this.img_vet)

            this.tv_nomVet.text = veterinariaActual.nombre_vet
            this.tv_telVet.text = veterinariaActual.telefono_vet
            this.tv_direVet.text = veterinariaActual.direccion_vet
        }



        return view
    }


}