package com.mora.victor.recyclerviewexample.fragment;

import com.mora.victor.recyclerviewexample.adapter.ContactoAdaptador;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 21-May-17.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
