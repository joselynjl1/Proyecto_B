package com.example.proyecto_b.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_b.R
import com.example.proyecto_b.model.Conferencia
import com.example.proyecto_b.view.adapter.ConferenciaAdapter
import com.example.proyecto_b.viewmodel.ConferenciaViewModel
import kotlinx.android.synthetic.main.fragment_calendario.*

class CalendarioFragment : Fragment() {

    private lateinit var conferenciaAdapter: ConferenciaAdapter
    private lateinit var viewModel: ConferenciaViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //traer el fragmento
        return inflater.inflate(R.layout.fragment_calendario,container,false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(ConferenciaViewModel::class.java)
        viewModel.refresh()

        conferenciaAdapter=ConferenciaAdapter(this)
        RVCalendario.apply {
            //para que se muestre de forma veritcal
            layoutManager=LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter=conferenciaAdapter
        }
        observeViewModel()
    }

    //ver funcionnn

    fun observeViewModel() {
        //viewModel.listadoconferencias.observe(this, Observer<List<Conferencia>>{ conferencia ->
            //conferenciaAdapter.updatedat(conferencia)
    }//)


}