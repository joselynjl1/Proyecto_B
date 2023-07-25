package com.example.proyecto_b.network

import com.example.proyecto_b.model.Conferencia
import com.example.proyecto_b.model.Ponente
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

//tablas de la bd
const val PONENTES_COLLECTION_NAMES="ponentes"
const val CONFERENCIAS_COLLECTION_NAMES="Conferencias"

class FirestoreService{
    val firestoreFirebase=FirebaseFirestore.getInstance()
    //el setPersitencia crea la presintencia?, creando la configuracion
    val settings=FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
    //el constructor aqui es init

    init{
        firestoreFirebase.firestoreSettings=settings
    }

    fun getPonentes(callback:Callback<List<Ponente>>){
        firestoreFirebase.collection(PONENTES_COLLECTION_NAMES)
                //los ordene por su categoria
            .orderBy("categoria")
            .get()
            .addOnSuccessListener { result->
                for (doc in result){
                    val list=result.toObjects(Ponente::class.java)
                    callback.onSucces(list)
                    break
                }
            }
    }

    fun getConferencias(callback: Callback<List<Conferencia>>){
        firestoreFirebase.collection(CONFERENCIAS_COLLECTION_NAMES)
            .get()
            .addOnSuccessListener { result->
                for(doc in result){
                    val list=result.toObjects(Conferencia::class.java)
                    callback.onSucces(list)
                    break
                }
            }
    }



}
