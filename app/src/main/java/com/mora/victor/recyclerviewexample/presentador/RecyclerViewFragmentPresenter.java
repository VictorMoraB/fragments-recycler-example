package com.mora.victor.recyclerviewexample.presentador;

import android.content.Context;

import com.mora.victor.recyclerviewexample.db.ConstructorContactos;
import com.mora.victor.recyclerviewexample.fragment.IRecyclerViewFragmentView;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 21-May-17.
 */

public class RecyclerViewFragmentPresenter  implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context contexto;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,
                                         Context contexto)
    {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.contexto = contexto;
        obtenerContactosBaseDatos();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(contexto);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(
                iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
