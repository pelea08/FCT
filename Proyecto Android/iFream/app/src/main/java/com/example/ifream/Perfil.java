package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Perfil extends AppCompatActivity {
    TextView nombre;
    TextView nPubli, nSeguidores, nSiguiendo;
    private RequestQueue queue;
    InicioSesion s = new InicioSesion();
    Button btnCerrarSesion, btnCerrarSesionYEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnCerrarSesionYEliminar = findViewById(R.id.btnCerrarSesionYEliminar);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        nombre = findViewById(R.id.nombreUsuario);
        nPubli = findViewById(R.id.nPublicaciones);
        nSeguidores = findViewById(R.id.nSeguidores);
        nSiguiendo = findViewById(R.id.nSiguiendo);

        nombre.setText(s.nombreS);
        queue = Volley.newRequestQueue(this);
        obtenerNumeroPublis();
        obtenerSeguidores();
        obtenerSeguidos();
//
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Revisar el volver a la sesion con el mismo usuario
                Intent intent = new Intent(Perfil.this, InicioSesion.class);
                startActivity(intent);
            }
        });
        btnCerrarSesionYEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask<String, Void, String> des = new borrarySalir(getApplicationContext()).execute(s.nombreS);
                Intent intent = new Intent(Perfil.this, InicioSesion.class);
                startActivity(intent);
            }
        });
    }

    public static class borrarySalir extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public borrarySalir(Context context) {
            this.context = new WeakReference<>(context);
        }


        @Override
        protected String doInBackground(String... params) {
            String registroUrl = "http://fctulises.atwebpages.com/borrarPerfil.php";
            String resultado;

            try {
                URL url = new URL(registroUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String nombre = params[0];
                String data = URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(nombre, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (isCancelled())
                        break;
                    stringBuilder.append(line);
                }
                resultado = stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (MalformedURLException e) {
                Log.d("MiAPP", "Se ha utilizado una URL con formato incorrecto");
                resultado = "Se ha producido un ERROR";
            } catch (IOException e) {
                Log.d("MiAPP", "Error inesperado!, posibles problemas de conexion de red");
                resultado = "Se ha producido un ERROR, comprueba tu conexion a Internet";
            }
            return resultado;
        }

        public void onPostExecute(String resultado) {
//            Log.i(TAG, "" + resultado);
        }
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
