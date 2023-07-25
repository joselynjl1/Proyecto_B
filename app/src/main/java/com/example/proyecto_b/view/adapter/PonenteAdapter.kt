package com.example.proyecto_b.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.proyecto_b.R
import com.example.proyecto_b.model.Conferencia
import com.example.proyecto_b.model.Ponente

class PonenteAdapter(val ponenteListener: PonenteListener): RecyclerView.Adapter<PonenteAdapter.ViewHolder>(){
    val listadoPonente=ArrayList<Ponente>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.itemexpositores, parent,false))

    override fun getItemCount()=listadoPonente.size

    override fun onBindViewHolder(holder: PonenteAdapter.ViewHolder, position: Int) {
        val ponente=listadoPonente[position] as Ponente

        holder.tvnombreponente.text=ponente.nombre
        holder.tvtrabajoponente.text=ponente.trabajo

        //traer la imagen y tranformarla con Glide
        Glide.with(holder.itemView.context)
            .load(ponente.imagen)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivimageponente)

        holder.itemView.setOnClickListener{
            ponenteListener.onPonenteClicked(ponente,position)
        }
    }

    fun updatedat(data: List<Ponente>){
        listadoPonente.clear()
        listadoPonente.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder (itemview: View): RecyclerView.ViewHolder(itemview){
        val tvnombreponente=itemView.findViewById<TextView>(R.id.TVPrimerNombre)
        val tvtrabajoponente=itemView.findViewById<TextView>(R.id.TVTrabajo)
        val ivimageponente=itemView.findViewById<ImageView>(R.id.IVImagenPonente)
    }
}

