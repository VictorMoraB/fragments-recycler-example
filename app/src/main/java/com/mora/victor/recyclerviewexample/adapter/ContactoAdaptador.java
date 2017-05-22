package com.mora.victor.recyclerviewexample.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mora.victor.recyclerviewexample.pojo.Contacto;
import com.mora.victor.recyclerviewexample.R;
import com.mora.victor.recyclerviewexample.detalle_contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 13-May-17.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>

{

    ArrayList<Contacto> contactos;
    private Activity parentActivity;

    public ContactoAdaptador(ArrayList<Contacto> Contactos, Activity activity){
        contactos = Contactos;
        parentActivity = activity;
    }


    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //construir un view a partir del xml definido para el cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,
                parent, false);
/*
       v.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //get id

               Intent intent = new Intent(parentActivity, detalle_contacto.class);

                parentActivity.startActivity(intent);
           }
       });
*/

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, final int position) {

        final Contacto contacto = contactos.get(position);
        holder.tvNombre.setText(contacto.getNombre());
        holder.tvTelefono.setText(contacto.getTelefono());
        holder.imgFoto.setImageResource(contacto.getImagen());
        holder.tvCorreo.setText(contacto.getCorreo());
        holder.tvLikes.setText(Integer.toString(contacto.getLikesCount()));
        holder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacto.setLikesCount(contacto.getLikesCount()+1);
                notifyItemChanged(position);
            }
        });



    }



    @Override
    public int getItemCount() { //cantidad de elementos que contiene la lista
        return contactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private TextView tvCorreo;
        private TextView tvLikes;
        private ImageView ivLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView)itemView.findViewById(R.id.imgFotoCV);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTelefono = (TextView)itemView.findViewById(R.id.tvTelefonoCV);
            tvCorreo = (TextView)itemView.findViewById(R.id.tvCorreoCV);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikesCV);
            ivLike = (ImageView)itemView.findViewById(R.id.ivFishyLike);

        }
    }
}

