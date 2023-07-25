package com.example.proyecto_b.view.adapter

import com.example.proyecto_b.model.Conferencia

interface ConferenciaListener {
    fun onConferenciaClicked(conferencia: Conferencia, position:Int)
}