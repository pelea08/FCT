package com.example.ifream;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Elemento> implements View.OnClickListener {
    ArrayList<ClasePrincipal> almacen;
    RecyclerView rv;
    private View.OnClickListener listener;

    public MiAdaptador(ArrayList<ClasePrincipal> pelis, RecyclerView rv) {
        this.almacen = pelis;
        this.rv = rv;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

        if (listener != null) {
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public MiAdaptador.Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.posicion, parent, false);
        elemento1.setOnClickListener(this);
        Elemento recElemento = new MiAdaptador.Elemento(elemento1);
        return recElemento;
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView nombrePubli;
        TextView autor;
        ImageView foto;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.nombrePubli = itemView.findViewById(R.id.nombrPublicacion);
            this.autor = itemView.findViewById(R.id.txtAutor);
            this.foto = itemView.findViewById(R.id.imageView);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Elemento holder, int position) {
        ClasePrincipal pe = this.almacen.get(position);
        holder.nombrePubli.setText(pe.getNombrePublicacion());
        holder.autor.setText(pe.getautor());
        holder.foto.setImageBitmap(pe.getImagen());
//        holder.foto.setImageBitmap(BitmapFactory.decodeFile(pe.getImagen()));
//        holder.foto.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(pe.getImagen())));
    }

    @Override
    public int getItemCount() {
        return this.almacen.size();
    }
}
