package com.example.proyecto_b.view.adapter

import com.example.proyecto_b.model.Ponente

interface PonenteListener {
    fun onPonenteClicked(ponente: Ponente,position:Int)
}