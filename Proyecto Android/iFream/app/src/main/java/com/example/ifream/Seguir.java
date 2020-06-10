package com.example.ifream;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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

public class Seguir {
    public Context context;

    private static final String TAG = "my";

    //Parametro 1=nombre Seguido
//Parametro 2=nombre Seguidor
    public static class seguirr extends AsyncTask<String, Void, String> {

        private WeakReference<Context> context;

        public seguirr(Context context) {
            this.context = new WeakReference<>(context);
        }


        @Override
        protected String doInBackground(String... params) {
            String registroUrl = "http://fctulises.atwebpages.com/seguir.php";
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

                String data = URLEncoder.encode("usuario1", "UTF-8") + "=" + URLEncoder.encode(nombreee, "UTF-8")
                        + "&" + URLEncoder.encode("usuario2", "UTF-8") + "=" + URLEncoder.encode(passs, "UTF-8");

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
}
