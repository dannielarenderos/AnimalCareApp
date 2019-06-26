package com.example.animalcare.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.animalcare.Constants
import com.example.animalcare.R
import kotlinx.android.synthetic.main.fragment_especies.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment_Especies : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_especies, container, false)


        view.iv_perro.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Especies_to_fragment_Animal)
            Constants.especie = "perro"
        }


        view.iv_gato.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Especies_to_fragment_Gato)
            Constants.especie = "gato"
        }
        return view

    }


}
