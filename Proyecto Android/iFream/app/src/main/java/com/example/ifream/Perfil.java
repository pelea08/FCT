package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Perfil extends AppCompatActivity {
    TextView nombre;
    TextView nPubli, nSeguidores, nSiguiendo;
    private RequestQueue queue;
    int publicacionesTotal, seguidores;
    InicioSesion s = new InicioSesion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nombre = findViewById(R.id.nombreUsuario);
        nPubli = findViewById(R.id.nPublicaciones);
        nSeguidores = findViewById(R.id.nSeguidores);
        nSiguiendo = findViewById(R.id.nSiguiendo);

        nombre.setText(s.nombreS);


        queue = Volley.newRequestQueue(this);
        try {
            obtenerNumeroPublis();
            obtenerSeguidores();
            obtenerSeguidos();
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Hacer dos json  y jugar con ellos
    }

    private void obtenerNumeroPublis() {
        String url = "http://fctulises.atwebpages.com/src/post.php?NombreR=" + s.nombreS;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Es una tonteria crear una variable y recorrer el response pudiendo hacer esto de golpe
                nPubli.setText("" + response.length());
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
    private void obtenerSeguidores() {
        String url = "http://fctulises.atwebpages.com/src/post2.php?nombreSeguido=" + s.nombreS;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                nSeguidores.setText("" + response.length());

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
    private void obtenerSeguidos() {
        String url = "http://fctulises.atwebpages.com/src/post2.php?nombreSeguidor=" + s.nombreS;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                nSiguiendo.setText("" + response.length());

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
