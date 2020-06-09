package com.example.ifream;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Elemento> implements View.OnClickListener {
    ArrayList<ClasePrincipal> almacen;
    RecyclerView rv;
    private View.OnClickListener listener;
    static inicio a = new inicio();

    public MiAdaptador(ArrayList<ClasePrincipal> pelis, RecyclerView rv) {
        this.almacen = pelis;
        this.rv = rv;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MiAdaptador.Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.posicion, parent, false);
        elemento1.setOnClickListener(this);
        Elemento recElemento = new MiAdaptador.Elemento(elemento1);
        int pos=recElemento.getAdapterPosition();

        return recElemento;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(v);

    }

    public static class Elemento extends RecyclerView.ViewHolder {
        Context context;
        TextView nombrePubli;
        TextView autor;
        ImageView foto;

        Button botonSeguir;
        Button botonComentar;

        public Elemento(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            this.nombrePubli = itemView.findViewById(R.id.nombrPublicacion);
            this.autor = itemView.findViewById(R.id.txtAutor);
            this.foto = itemView.findViewById(R.id.imageView);

            botonSeguir = itemView.findViewById(R.id.btnSeguir);
            botonComentar = itemView.findViewById(R.id.btnComentarios);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull final MiAdaptador.Elemento holder, final int position) {
        ClasePrincipal pe = this.almacen.get(position);
        holder.nombrePubli.setText(pe.getNombrePublicacion());
        holder.autor.setText(pe.getautor());
        holder.foto.setImageBitmap(pe.getImagen());


        holder.botonSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(holder.context, "seguir", Toast.LENGTH_SHORT).show();
                inicioSesion a = new inicioSesion();
                inicio b = new inicio();
                String usuarioActual = a.nombreS;
                Toast.makeText(holder.context, "Esta es la pos que pulse: " + position, Toast.LENGTH_SHORT).show();
                //obtener id foto actual
                //si se en que pos i pincho con acceder al array mediante i ya estaria
//                "SELECT NombreR FROM publicaciones where Identificador='$var_PHP'";
            }
        });
        holder.botonComentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.context, "comentaaaar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.almacen.size();
    }
}
