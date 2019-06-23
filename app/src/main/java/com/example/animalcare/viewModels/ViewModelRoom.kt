package com.example.animalcare.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.viewModelScope
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.animalcare.database.RoomDB
import com.example.animalcare.database.entities.*
import com.example.animalcare.repositories.*
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom(context: Application): AndroidViewModel(context){
    private val leyRepository: LeyRepository
    private val orgRepository: OrgRepository
    private val enfRepository: EnfRepository
    private val curRepository: CurRepository
    private val vetRepository: VetRepository


    var allLaws: LiveData<List<ley_entity>>
    val listaLeyes = MutableLiveData<MutableList<ley_entity>>()
    var allOrgs: LiveData<List<org_entity>>
    val listaOrgs = MutableLiveData<MutableList<org_entity>>()
    var allEnfs: LiveData<List<enfermedad_entity>>
    val listaEnfs = MutableLiveData<MutableList<enfermedad_entity>>()
    var allCurs: LiveData<List<curiosidad_entity>>
    val listaCurs = MutableLiveData<MutableList<curiosidad_entity>>()
    var allVets: LiveData<List<vet_entity>>
    val listaVets = MutableLiveData<MutableList<vet_entity>>()

    init {
        val leyDao = RoomDB.getInstance( context,viewModelScope).leyDao()
        val orgDao = RoomDB.getInstance( context, viewModelScope).orgDao()
        val enfDao = RoomDB.getInstance( context, viewModelScope).enferDao()
        val curDao = RoomDB.getInstance( context, viewModelScope).curDao()
        val vetDao = RoomDB.getInstance( context, viewModelScope).vetDao()
        //val orgDao= RoomDB.getInstance(context).orgDao()
        //repository= Repository(orgDao, leyDao)
        orgRepository = OrgRepository(orgDao)
        leyRepository = LeyRepository(leyDao)
        enfRepository = EnfRepository(enfDao)
        curRepository = CurRepository(curDao)
        vetRepository = VetRepository(vetDao)
        allOrgs= orgRepository.allOrgs
        allLaws= leyRepository.allLeyes
        allEnfs = enfRepository.allEnfermedades
        allCurs = curRepository.allCuriosidades
        allVets = vetRepository.allVets

    }

    fun getAllLeyes() = viewModelScope.launch(Dispatchers.IO) {
        val response = leyRepository.retrieveLeyes().await()
        if(response.isSuccessful){
            if(response.code()==200){
                listaLeyes.postValue(response.body()?.toMutableList()?:arrayListOf(ley_entity("idDef", "aparDef", "artiDef")))
            }
        }
    }

    fun getAllLOrgs() = viewModelScope.launch(Dispatchers.IO) {
        val response = orgRepository.retrieveOrgs().await()
        if(response.isSuccessful){
            if(response.code()==200){
                listaOrgs.postValue(response.body()?.toMutableList()?:arrayListOf(org_entity("idDef", "aparDef", "artiDef", "","k")))
            }
        }
    }

    fun getAllEnf() = viewModelScope.launch(Dispatchers.IO) {
        val response = enfRepository.retrieveEnfs().await()
        if(response.isSuccessful){
            if(response.code()==200){
                listaEnfs.postValue(response.body()?.toMutableList()?:arrayListOf(enfermedad_entity("idDef", "nomDef", "tipoDef", "dinDef","treDif","espDif")))
            }
        }
    }

    fun getAllCur() = viewModelScope.launch(Dispatchers.IO) {
        val response = curRepository.retrieveCuriosidades().await()
        if(response.isSuccessful){
            if(response.code()==200){
                listaCurs.postValue(response.body()?.toMutableList()?:arrayListOf(curiosidad_entity("idDef", "nomDef")))
            }
        }
    }

    fun getAllVet() = viewModelScope.launch(Dispatchers.IO) {
        val response = vetRepository.retrieveVets().await()
        if(response.isSuccessful){
            if(response.code()==200){
                listaVets.postValue(response.body()?.toMutableList()?:arrayListOf(vet_entity("idDef", "imgDef","nomDef","telDef","dirDef")))
            }
        }
    }



}
