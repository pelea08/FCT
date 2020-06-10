package com.example.ifream;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import java.util.concurrent.ExecutionException;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Elemento> implements View.OnClickListener {
    ArrayList<ClasePrincipal> almacen;
    RecyclerView rv;
    private View.OnClickListener listener;
    static public String posicionSelecionada;
    static Inicio a = new Inicio();

    public MiAdaptador() {
    }
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
        int pos = recElemento.getAdapterPosition();

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
//Parametro 1=nombre Seguido
//Parametro 2=nombre Seguidor
                Toast.makeText(holder.context, "Seguir", Toast.LENGTH_SHORT).show();
                InicioSesion a = new InicioSesion();
                Inicio b = new Inicio();
                String usuarioActual = a.nombreS;

                String autorPublicacion = b.almacenGeneral.get(position).getautor();
                posicionSelecionada=b.almacenGeneral.get(position).getIdentificador();
                Toast.makeText(holder.context, "Esta es la pos que pulse: " + autorPublicacion, Toast.LENGTH_SHORT).show();
                Seguir s = new Seguir();
                AsyncTask<String, Void, String> des = new Seguir.seguirr(holder.context).execute(autorPublicacion, usuarioActual);
                try {
                    String aa = des.get();
                    Thread.sleep(3 * 1000);
                    //CODIGO QUE DEVUELVE CUANDO EL LOGEO ES EXITOSO
                    if (aa.trim().equals("asdasdasdasdas")) {
                        Toast.makeText(holder.context, "Se supone que good", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(holder.context, "La relaccion ya existe", Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        holder.botonComentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(holder.context,Comentario.class);
                holder.context.startActivity(a);
                Comentario c=new Comentario();
                Inicio b = new Inicio();
                c.id=b.almacenGeneral.get(position).getIdentificador();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.almacen.size();
    }
}
