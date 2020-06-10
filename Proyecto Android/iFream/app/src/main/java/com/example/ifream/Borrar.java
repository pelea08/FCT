package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Borrar extends AppCompatActivity {
    RecyclerView.LayoutManager miLayoutManager;

    static public ArrayList<ClasePrincipal> almacenGeneral2 = new ArrayList<>();

    static public ArrayList<String> almacenUsuario2 = new ArrayList<String>();

    static public ArrayList<String> alamcenTitulos2 = new ArrayList<String>();
    static public ArrayList<Bitmap> almacenImagenesConvertidas2 = new ArrayList<Bitmap>();
    static public ArrayList<String> almacenContadorVisitas2 = new ArrayList<String>();
    static public ArrayList<String> almacenId = new ArrayList<String>();
    static boolean actualizar = false;
    RecyclerView rv;
    final String TAG = "MyActivity";
    Button btnBorrar;

    static public String posicionPasar = "";

    int pos;
    InicioSesion varaiblesInicio = new InicioSesion();
    boolean borrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        //Porque si no cada vez se suma
        btnBorrar = findViewById(R.id.btnBorrar);

        for (int i = 0; i < almacenUsuario2.size(); i++) {
            if (almacenUsuario2.get(i).equals(varaiblesInicio.nombreS)) {
                //EVITAR REPETICION
                if (!actualizar) {
                    almacenGeneral2.add(new ClasePrincipal(almacenId.get(i), almacenImagenesConvertidas2.get(i), alamcenTitulos2.get(i), almacenContadorVisitas2.get(i)));
                }
            }
        }
        actualizar = true;


        rv = findViewById(R.id.recicler3);
        final MiAdaptador2 p = new MiAdaptador2(almacenGeneral2, rv);

        miLayoutManager = new GridLayoutManager(this, 1);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(p);

        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = rv.getChildAdapterPosition(v);
                Toast.makeText(getApplicationContext(), "Has selecionado un elemento", Toast.LENGTH_SHORT).show();
            }
        };
        p.setOnClickListener(listener);


        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos > -1) {
                    String id = almacenGeneral2.get(pos).getIdentificador();

                    AsyncTask<String, Void, String> des = new Borrar.Borrado(getApplicationContext()).execute(id);
//                    Ejecutar sentencia de delete desde api pasandole el id y via
                    Toast.makeText(getApplicationContext(), "La publicacion ha sido borrada" + id, Toast.LENGTH_SHORT).show();

                    borrado = true;
                    almacenGeneral2.remove(pos);
//                    almacenGeneral.remove(pos);
                    p.notifyItemRemoved(pos);
                    posicionPasar = id;
//                    pe.notifyItemRemoved(pos);


                }
            }
        });
    }

    public class Borrado extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public Borrado(Context context) {
            this.context = new WeakReference<>(context);
        }


        @Override
        protected String doInBackground(String... params) {
            String registroUrl = "http://fctulises.atwebpages.com/src/post.php?Identificador=" + params[0];
            String resultado;

            try {
                URL url = new URL(registroUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("DELETE");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

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

            Log.i(TAG, "" + resultado);

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

