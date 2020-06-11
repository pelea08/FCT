package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Comentario extends AppCompatActivity {
    TextView txtTexto;
    private RequestQueue queue;
    ArrayList<String> almacenComentarios = new ArrayList<>();
    MiAdaptador miAdaptador = new MiAdaptador();
    public static String id;
    Button btnAñadir;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);
        txtTexto = findViewById(R.id.textView7);
        //Hacer un obtener datos volley que apunte a posts1
        //que a su vez a punte a comentarios y pasasmos el id de la publicacion y el resultado = al textview
        btnAñadir = findViewById(R.id.button2);
        text = findViewById(R.id.editText2);
        queue = Volley.newRequestQueue(this);
        try {
            obtenerTexto();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AsyncTask<String, Void, String> des = new InicioSesion.Logeo(getApplicationContext()).execute(nombreS, contraseñaC);
                //id y texto
                String textoEnviar=text.getText().toString();
                InicioSesion s=new InicioSesion();
                String usuario="@"+s.nombreS+":";
                AsyncTask<String, Void, String> des = new FuncionComentario.Comentario(getApplicationContext()).execute(id,usuario+textoEnviar);

                try {
                    String aa = des.get();
                    Thread.sleep(3 * 1000);
                    //CODIGO QUE DEVUELVE CUANDO EL LOGEO ES EXITOSO
                    if (aa.trim().equals("gg")) {
                        Toast.makeText(getApplicationContext(), "Se supone que good", Toast.LENGTH_SHORT).show();
                        //Si es correcto actualiza lo que ves
                        obtenerTexto();
                    } else {
                        Toast.makeText(getApplicationContext(), "La cagaste", Toast.LENGTH_SHORT).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    private void obtenerTexto() {
        String url = "http://fctulises.atwebpages.com/src/post1.php?IdPublicacionRel=" + id;


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject mJsonObject = response.getJSONObject(i);
                        String textoComentario = mJsonObject.getString("Texto");
                        txtTexto.setText(textoComentario);
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
