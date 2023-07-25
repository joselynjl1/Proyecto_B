package com.example.proyecto_b.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto_b.model.Conferencia
import com.example.proyecto_b.model.Ponente
import com.example.proyecto_b.network.Callback
import com.example.proyecto_b.network.FirestoreService
import org.checkerframework.checker.units.qual.C
import java.lang.Exception

class ConferenciaViewModel:ViewModel(){
    //ya que tenemos creado la instancia con firestore
    //llamamos al servicio de la bd
    val firestoreservices=FirestoreService()
    //de quien cambiara la vista--> de conferencias
    val listadoconferencias:MutableLiveData<List<Conferencia>?> = MutableLiveData()
    val isloading=MutableLiveData<Boolean>()

    fun refresh(){
        getConferenciaFromFirebase()
    }

    private fun getConferenciaFromFirebase() {

        firestoreservices.getConferencias(object: Callback<List<Conferencia>> {
            @SuppressLint("NullSafeMutableLiveData")
            //2 miembros implementados de Object
            override fun onSucces(result: List<Conferencia>?) {
                listadoconferencias.postValue(result)
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