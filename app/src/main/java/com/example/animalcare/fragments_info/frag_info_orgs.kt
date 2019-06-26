package com.example.animalcare.fragments_info


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animalcare.Constants
import com.example.animalcare.R
import com.example.animalcare.activities.GlideApp
import com.example.animalcare.database.entities.org_entity
import kotlinx.android.synthetic.main.fragment_frag_info_orgs.view.*


class frag_info_orgs : Fragment() {

    lateinit var organizacionActual: org_entity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        organizacionActual = Constants.organizacion!!
        val view = inflater.inflate(R.layout.fragment_frag_info_orgs, container, false).apply {
            GlideApp.with(this)
                    .load(organizacionActual.img_org)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(this.img_organizacion)

            this.tv_nombreOrga.text = organizacionActual.nombre_org
            this.tv_telefonoOrga.text = organizacionActual.telefono_org
            this.tv_direccionOrga.text = organizacionActual.direccion_org

        }



        return view
    }


}
