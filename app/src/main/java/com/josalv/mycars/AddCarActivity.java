package com.josalv.mycars;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Comprobar si la actividad ya ha sido creada con anterioridad
        if (savedInstanceState == null) {
        // Crear un fragment
            AddCarFragment fragment = new AddCarFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment,
                            fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    // Añadimos las opciones de menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.carList:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.addCar:
                startActivity(new Intent(this, AddCarActivity.class));
                return true;
            case R.id.info:
                createSimpleDialog().show();
                return true;
            default:
                return false;
        }
    }

    /**
     * Crea un nuevo mensaje de alerta. Se muestra con show().
     * @return Nuevo mensaje de alerta
     */
    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Code with love by")
                .setMessage("Alvaro Velasco & Jose Alberto del Val");
        return builder.create();
    }
}
