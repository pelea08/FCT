package com.example.ifream;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador2 extends RecyclerView.Adapter<MiAdaptador2.Elemento> implements View.OnClickListener {
    ArrayList<ClasePrincipal> almacen;
    RecyclerView rv;
    private View.OnClickListener listener;

    public MiAdaptador2(ArrayList<ClasePrincipal> pelis, RecyclerView rv) {
        this.almacen = pelis;
        this.rv = rv;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public MiAdaptador2.Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.posicion2, parent, false);
        elemento1.setOnClickListener(this);
        Elemento recElemento = new MiAdaptador2.Elemento(elemento1);
        return recElemento;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador2.Elemento holder, int position) {
        ClasePrincipal pe = this.almacen.get(position);
        holder.nombrePubli2.setText(pe.getNombrePublicacion());
        holder.contador.setText(pe.getContadorVisitas());
        holder.foto2.setImageBitmap(pe.getImagen());

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView nombrePubli2;
        TextView contador;
        ImageView foto2;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.nombrePubli2 = itemView.findViewById(R.id.nombrPublicacion2);
            this.contador = itemView.findViewById(R.id.contador);
            this.foto2 = itemView.findViewById(R.id.imageView2);
        }
    }

    @Override
    public int getItemCount() {
        return this.almacen.size();
    }
}