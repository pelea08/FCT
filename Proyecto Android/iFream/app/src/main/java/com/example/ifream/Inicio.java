package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.os.FileUtils.copy;

public class Inicio extends AppCompatActivity {

    RecyclerView.LayoutManager miLayoutManager;
    public ArrayList<String> almacenNombres = new ArrayList<String>();
    public ArrayList<String> almacenAutor = new ArrayList<String>();
    public ArrayList<String> almacenImagenes = new ArrayList<String>();
    static public ArrayList<ClasePrincipal> almacenGeneral = new ArrayList<ClasePrincipal>();
    public ArrayList<Bitmap> almacenImagenesConvertidas = new ArrayList<Bitmap>();
    public ArrayList<String> almacenContadorVisitas = new ArrayList<String>();
    public ArrayList<String> almacenIDD = new ArrayList<String>();

    static Context contextInicio;
    FloatingActionButton añadirFl;
    FloatingActionButton logOutFl, menoFlo;
    RecyclerView rv;
    final String TAG = "MyActivity";
    private RequestQueue queue;
    Borrar variables = new Borrar();
    FloatingActionButton btnRecarga;
    FloatingActionButton btnPerf;
    MiAdaptador pe;
    static public int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        contextInicio = getApplicationContext();
        añadirFl = findViewById(R.id.floatingActionButton);
        logOutFl = findViewById(R.id.floatingActionButton2);
        menoFlo = findViewById(R.id.floatingActionButton3);
        btnRecarga = findViewById(R.id.btnRecarga);
        btnPerf = findViewById(R.id.btnPerfil);
        btnPerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, Perfil.class);
                startActivity(intent);
            }
        });
        menoFlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, Borrar.class);
                startActivity(intent);
            }
        });

        logOutFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, MainActivity.class);
                startActivity(intent);
            }
        });
        añadirFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, AnadirPublicacion.class);
                startActivity(intent);
            }
        });
        btnRecarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variables.posicionPasar != "") {
                    for (int i = 0; i < almacenGeneral.size(); i++) {
                        if (almacenGeneral.get(i).getIdentificador() == variables.posicionPasar) {
                            almacenGeneral.remove(i);
                            pe.notifyItemRemoved(i);


                        }
                    }
                }


            }
        });
        queue = Volley.newRequestQueue(this);
        try {
            obtenerInfo();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rv = findViewById(R.id.recicler2);
        pe = new MiAdaptador(almacenGeneral, rv);
        miLayoutManager = new GridLayoutManager(this, 1);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(pe);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = rv.getChildAdapterPosition(v);
            }
        };
        pe.setOnClickListener(listener);
    }

    void obtenerInfo() {
        String url = "http://fctulises.atwebpages.com/src/post.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject mJsonObject = response.getJSONObject(i);
                        String valor = mJsonObject.getString("Titulo");
                        String id = mJsonObject.getString("Identificador");
                        String contador = mJsonObject.getString("Likes");
                        String autor = mJsonObject.getString("NombreR");
                        String foto = mJsonObject.getString("Imagen");

                        almacenIDD.add(id);
                        variables.almacenId.add(id);
                        almacenAutor.add(autor);
                        variables.almacenUsuario2.add(autor);
                        almacenNombres.add(valor);
                        variables.alamcenTitulos2.add(valor);
                        almacenImagenes.add(foto);
                        almacenContadorVisitas.add(contador);
                        variables.almacenContadorVisitas2.add(contador);
                        Toast.makeText(Inicio.this, "Imagen: " + foto, Toast.LENGTH_SHORT).show();
                    }

                    for (int j = 0; j < almacenImagenes.size(); j++) {
                        AsyncTask<String, Void, Bitmap> s = new AsyncFoto().execute(almacenImagenes.get(j));
                        try {
                            Bitmap fotoActual = s.get();
                            Thread.sleep(3000);
                            almacenImagenesConvertidas.add(fotoActual);
                            variables.almacenImagenesConvertidas2.add(fotoActual);
                            almacenGeneral.add(new ClasePrincipal(almacenIDD.get(j), almacenImagenesConvertidas.get(j), almacenNombres.get(j), almacenContadorVisitas.get(j), almacenAutor.get(j)));
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", "Error occurred ", error);
            }
        });
        queue.add(request);
        Toast.makeText(getApplicationContext(), "FIN SUPUESTAMNETE", Toast.LENGTH_SHORT).show();
    }

    private class AsyncFoto extends AsyncTask<String, Void, Bitmap> {
        Bitmap myBitmap;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, linken Gecko) Chrome/83.0.4103.61 Safari/537.36");
                connection.addRequestProperty("Referer", "http://fctulises.atwebpages.com/web/inicioUsuario.php");
                connection.connect();

                InputStream input = connection.getInputStream();
                myBitmap = BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return myBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            Log.i(TAG, "a:   " + myBitmap);
        }
    }

    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int opciones = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Oculta la barra de navegación
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(opciones);
        getSupportActionBar().hide();
    }
}
