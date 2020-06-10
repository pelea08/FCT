package com.example.ifream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.util.Calendar;


public class Registrarse extends AppCompatActivity {
    Button btnRegistrarse, btnFecha;
    EditText nombre, contraseña;
    Spinner spinner;
    String genero ;
    String fechaa;
    Calendar c;
    DatePickerDialog d;
    boolean banderaFecha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        nombre = findViewById(R.id.editText3);
        contraseña = findViewById(R.id.editText4);
        btnFecha = findViewById(R.id.btnFecha);

        final String[] genero1 = getResources().getStringArray(R.array.genero);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genero1);
        btnRegistrarse = findViewById(R.id.button);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genero = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int año = c.get(Calendar.YEAR);

                d = new DatePickerDialog(Registrarse.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int año, int mes, int dia) {
                        fechaa = año + "/" + mes + "/" + dia;
                        banderaFecha = true;
                    }
                }, dia, mes, año);
                d.show();


            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreS = nombre.getText().toString();
                String contraseñaC = contraseña.getText().toString();

                if (banderaFecha) {
                    String[] arrayFehca = fechaa.split("/");

                    if (Integer.valueOf(arrayFehca[2]) <= c.get(Calendar.YEAR) - 18) {
                        if (nombre != null && contraseñaC != null) {
                            String generoo = genero;

                            new Registro(Registrarse.this).execute(nombreS, contraseñaC, fechaa, generoo);

                        } else {
                            Toast.makeText(Registrarse.this, "Nombre o contraseña vacios inserte valores", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(Registrarse.this, "Valores en la fecha invalidos debes de tener mas de 17 años", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(Registrarse.this, "Introduzca una fecha pinchando en el boton", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public static class Registro extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public Registro(Context context) {
            this.context = new WeakReference<>(context);
        }

        @Override
        protected String doInBackground(String... params) {
            String registroUrl = "http://fctulises.atwebpages.com/registro.php";
            //String registroUrl = "http://fctulises.epizy.com/registro.php";
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
                String fechaa = params[2];
                String generoo = params[3];

                String data = URLEncoder.encode("usuario", "UTF-8") + "=" + URLEncoder.encode(nombreee, "UTF-8")
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(passs, "UTF-8")
                        + "&" + URLEncoder.encode("fecha", "UTF-8") + "=" + URLEncoder.encode(fechaa, "UTF-8")
                        + "&" + URLEncoder.encode("genero", "UTF-8") + "=" + URLEncoder.encode(generoo, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();

                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
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
            Toast.makeText(context.get(), "Se añadio correctamente ", Toast.LENGTH_LONG).show();

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
