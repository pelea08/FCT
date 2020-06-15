package com.example.ifream;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

class CargandoDialog {
    private Activity activity;
    private AlertDialog dialog;

    CargandoDialog(Activity myActivity) {
        activity = myActivity;
    }

    void empezarCarga() {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void destruitDialog() {
        dialog.dismiss();
    }
}
