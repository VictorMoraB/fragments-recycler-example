package com.mora.victor.recyclerviewexample.presentador;

import android.content.Context;

import com.mora.victor.recyclerviewexample.adapter.ContactoAdaptador;
import com.mora.victor.recyclerviewexample.fragment.IRecyclerViewFragmentView;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 21-May-17.
 */

public class RecyclerViewFragmentPresenter  implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context contexto;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,
                                         Context contexto)
    {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.contexto = contexto;
    }


    @Override
    public void obtenerContactosBaseDatos() {
        
    }

    @Override
    public void mostrarContactosRV() {

    }
}
