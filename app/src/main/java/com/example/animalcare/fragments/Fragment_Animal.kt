package com.example.animalcare.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.adapter.LeyAdapter
import com.example.animalcare.adapter.RazaAdapter
import com.example.animalcare.adapter.listaEspecie
import com.example.animalcare.service.retrofit.Especie
import com.example.animalcare.viewModels.ViewModelRoom


class Fragment_Animal : Fragment() {
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
            layoutManager = LinearLayoutManager(this@Fragment_Animal.context)
            adapter = razaAdapter
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.gellAllRazasPerro()
        viewModel.listaTodasRazas.observe(this, Observer { listaTodasRazas ->
            razaAdapter.updateList(listaTodasRazas)

            for (razas in listaTodasRazas) {
                Log.v("Raza", razas.personalidad_raza)
            }
        })

        return view
    }}





