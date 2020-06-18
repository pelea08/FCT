package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class InicioSesion extends AppCompatActivity {
    Button btnInicio;
    EditText usuario, contraseña;
    boolean entrar;
    final String TAG = "MyActivity";
    public static String nombreS;
    static public ArrayList<String> almacenIdRepeticion = new ArrayList<>();
    static public ArrayList<String> almacenUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        final CargandoDialog cargandoDialog = new CargandoDialog(InicioSesion.this);

        btnInicio = findViewById(R.id.btnInicioSesion1);
        usuario = findViewById(R.id.editTextNo);
        contraseña = findViewById(R.id.editTextContr);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargandoDialog.empezarCarga();
                //Ocultar teclado si no en determinadas dimensiones no se va a ver bien
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(contraseña.getWindowToken(), 0);
                nombreS = usuario.getText().toString();
                String contraseñaC = contraseña.getText().toString();

                AsyncTask<String, Void, String> des = new Logeo(getApplicationContext()).execute(nombreS, contraseñaC);
                try {
                    String aa = des.get();
                    //CODIGO QUE DEVUELVE CUANDO EL LOGEO ES EXITOSO
                    if (aa.trim().equals("asdasdasdasdas")) {
                        entrar = true;
                    } else {
                        entrar = false;
                    }
                    if (entrar) {
                        Intent intent = new Intent(InicioSesion.this, Inicio.class);
                        startActivity(intent);
                        //Cada vez que un usuario inicia sesion puede ir dar like a quin quiere
                        //pero cada id sobre el like se registra para evitar repeticion
                        almacenIdRepeticion = new ArrayList<>();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                cargandoDialog.destruitDialog();
                            }
                        }, 2000);
                    } else {
                        //Si es incorrecto sigue con la animacion y pasados 2 segundos cierralo
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Toast.makeText(InicioSesion.this, "Datos Erroneos", Toast.LENGTH_SHORT).show();
                                cargandoDialog.destruitDialog();
                            }
                        }, 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public class Logeo extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public Logeo(Context context) {
            this.context = new WeakReference<>(context);
        }


        @Override
        protected String doInBackground(String... params) {
            String registroUrl = "http://fctulises.atwebpages.com/login.php";
            String resultado;

            try {
                URL url = new URL(registroUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String nombreee = params[0];
                String passs = params[1];
                String data = URLEncoder.encode("usuario", "UTF-8") + "=" + URLEncoder.encode(nombreee, "UTF-8")
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(passs, "UTF-8");
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
            Log.i(TAG, "" + resultado);
        }
    }

    @Override
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
