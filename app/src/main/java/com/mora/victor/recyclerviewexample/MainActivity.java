package com.mora.victor.recyclerviewexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mora.victor.recyclerviewexample.adapter.PageAdapter;
import com.mora.victor.recyclerviewexample.fragment.Perfil;
import com.mora.victor.recyclerviewexample.fragment.RecyclerViewFragment;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variable to hold the toolbar
    private Toolbar miActionBar;
    private RecyclerView myRecycler;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        myRecycler = (RecyclerView)findViewById(R.id.rvContactos);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);


        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.spaceships_001, "Rocketman 01", "787878"));
        contactos.add(new Contacto(R.drawable.spaceships_002, "Rocketman 02", "74521358"));
        contactos.add(new Contacto(R.drawable.spaceships_003, "Rocketman 03", "7135768415"));
        contactos.add(new Contacto(R.drawable.spaceships_004, "Rocketman 04", "7135768415"));
        contactos.add(new Contacto(R.drawable.spaceships_005, "Rocketman 05", "7135768415"));

        setupViewPager();
        /*
        //crear el adaptador con base en el ArrayList de contactos
        ContactoAdaptador myContactAdapter = new ContactoAdaptador(contactos, this);

        //crear un adaptador de layout para controlar el display de los objetos dentro del recycler view
        LinearLayoutManager llm = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(llm);

        myRecycler.setAdapter(myContactAdapter);
        */


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());
        return  fragments;
    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }


}