package com.mora.victor.recyclerviewexample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mora.victor.recyclerviewexample.R;
import com.mora.victor.recyclerviewexample.adapter.ContactoAdaptador;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 19-May-17.
 */

public class RecyclerViewFragment extends android.support.v4.app.Fragment implements IRecyclerViewFragmentView
{

    private RecyclerView myRecycler;
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    private ContactoAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        myRecycler = (RecyclerView)v.findViewById(R.id.rvContactos);
        return  v;

    }

    /*
    private void inicializarContactos(){
        contactos.add(new Contacto(R.drawable.spaceships_001, "Rocketman 01",
                "787878", "rocket01@gmail.com", 23));
        contactos.add(new Contacto(R.drawable.spaceships_002, "Rocketman 02",
                "74521358", "rocket02@gmail.com", 28));
        contactos.add(new Contacto(R.drawable.spaceships_003, "Rocketman 03",
                "7135768415", "rocket03@gmail.com", 78));
        contactos.add(new Contacto(R.drawable.spaceships_004, "Rocketman 04",
                "7135768415", "rocket04@gmail.com", 14));
        contactos.add(new Contacto(R.drawable.spaceships_005, "Rocketman 05",
                "7135768415", "rocket05@gmail.com", 14));
    }
    */

    @Override
    public void generarLinearLayoutVertical() {
        //crear un adaptador de layout para controlar el display de los objetos dentro del recycler view
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        myRecycler.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {

        ContactoAdaptador myContactAdapter = new ContactoAdaptador(contactos, getActivity());
        return myContactAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        myRecycler.setAdapter(adaptador);

    }
}
