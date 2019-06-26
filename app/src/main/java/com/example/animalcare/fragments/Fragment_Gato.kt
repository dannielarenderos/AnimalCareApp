package com.example.animalcare.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.adapter.RazaAdapter
import com.example.animalcare.viewModels.ViewModelRoom
import kotlinx.android.synthetic.main.fragment_animal.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment_Gato : Fragment() {
    private lateinit var recyclerView_: RecyclerView
    lateinit var viewModel: ViewModelRoom
    lateinit var razaAdapter: RazaAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_animal, container, false)
        recyclerView_ = view.findViewById(R.id.rv_raza)
        razaAdapter = RazaAdapter(mutableListOf())

        recyclerView_.apply {
            layoutManager = LinearLayoutManager(this@Fragment_Gato.context)
            adapter = razaAdapter
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.gellAllRazasGato()
        viewModel.listaTodasRazas.observe(this, Observer { listaTodasRazas ->
            razaAdapter.updateList(listaTodasRazas)

            for (razas in listaTodasRazas) {
                Log.v("Raza", razas.personalidad_raza)
            }
        })



        return view
    }}





