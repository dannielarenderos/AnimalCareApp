package com.example.animalcare.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.animalcare.R
import com.example.animalcare.activities.MainActivity
import com.example.animalcare.viewModels.ViewModelRoom
import kotlinx.android.synthetic.main.fragment_enfermedad_slide.*
import kotlinx.android.synthetic.main.fragment_enfermedad_slide.view.*
import kotlinx.android.synthetic.main.fragment_especie_slide.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(com.example.animalcare.R.layout.fragment_enfermedad_slide, container, false)

        view.btnEnfermedades.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            startActivity(intent)

        }


        return view
    }
}