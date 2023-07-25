package com.example.proyecto_b.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_b.R
import com.example.proyecto_b.model.Conferencia
import java.text.SimpleDateFormat
import java.util.Calendar

class ConferenciaAdapter(val conferenciaListener: ConferenciaListener):RecyclerView.Adapter<ConferenciaAdapter.ViewHolder>() {
    val listadoConferencia=ArrayList<Conferencia>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.itemcalendario, parent,false))

    override fun getItemCount()=listadoConferencia.size

    override fun onBindViewHolder(holder: ConferenciaAdapter.ViewHolder, position: Int) {
        val conferencia=listadoConferencia[position] as Conferencia
        //titulo del model
        holder.tvnombreconferencia.text= conferencia.titulo
        holder.tvponenteconferencia.text=conferencia.ponente
        holder.tvtopicconferencia.text=conferencia.topico

        val simpleDateFormat=SimpleDateFormat("HH:MM")
        val simpleDateFormatAMPM=SimpleDateFormat("a")

        val calendario= Calendar.getInstance()
        calendario.time=conferencia.datetime
        val horaformato=simpleDateFormatAMPM.format(conferencia.datetime)

        holder.tvhoraconferencia.text=horaformato
        holder.tvAMPMconferencia.text=simpleDateFormatAMPM.format(conferencia.datetime).toUpperCase()

        holder.itemView.setOnClickListener{
            conferenciaListener.onConferenciaClicked(conferencia,position)
        }
    }

    fun updatedat(data: List<Conferencia>){
        listadoConferencia.clear()
        listadoConferencia.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val tvnombreconferencia=itemView.findViewById<TextView>(R.id.TVConferencia)
        val tvponenteconferencia=itemView.findViewById<TextView>(R.id.TVExpositora)
        val tvtopicconferencia=itemView.findViewById<TextView>(R.id.TVTopico)
        val tvhoraconferencia=itemView.findViewById<TextView>(R.id.TVHora)
        val tvAMPMconferencia=itemView.findViewById<TextView>(R.id.TVAMPM)
    }
}