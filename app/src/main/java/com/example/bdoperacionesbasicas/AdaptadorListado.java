package com.example.bdoperacionesbasicas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorListado extends ArrayAdapter {
    private Activity context;
    private String[] arrayDatos;
    public AdaptadorListado(@NonNull Activity context, int layoutPersonalizado, String[] arrayDatos) {
        super(context, layoutPersonalizado, arrayDatos); //Más adelante arrayPlanetas será un array de objetos
        this.context=context;
        this.arrayDatos=arrayDatos;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Inflar: genera objetos java a partir de elementos xml.
        //Este método es llamado cada vez que se inserta un elemento en la lista.

        //Creamos un objeto inflador para convertir nuestro layout de fila en un objeto java manipulable
        //que será rellenado con los datos pertinentes
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View fila=layoutInflater.inflate(R.layout.fila_simple,null);
        TextView tvUsuario=fila.findViewById(R.id.tvUsuario);
        //Usaremos el int position como índice para establecer el contenido
        tvUsuario.setText(arrayDatos[position]);
        return fila;
    }
}
