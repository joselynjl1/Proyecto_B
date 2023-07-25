package com.example.proyecto_b.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.proyecto_b.model.Ponente
import com.example.proyecto_b.network.Callback
import com.example.proyecto_b.network.FirestoreService
import java.lang.Exception

class PonentesViewModel {
    val firestoreservices=FirestoreService()
    val listadoponentes:MutableLiveData<List<Ponente>?> = MutableLiveData()
    //para saber si esta cargando o no
    val isloading=MutableLiveData<Boolean>()

    fun refresh(){
        getPonenteFromFirebase()
    }

    private fun getPonenteFromFirebase() {
        firestoreservices.getPonentes(object: Callback<List<Ponente>>{
            @SuppressLint("NullSafeMutableLiveData")
            override fun onSucces(result: List<Ponente>?) {
                listadoponentes.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })
    }

    private fun processFinished() {
        isloading.value=true
    }


}

