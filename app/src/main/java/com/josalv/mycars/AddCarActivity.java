package com.josalv.mycars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //No necesario, crearia sobre la otra
        //setContentView(R.layout.fragment_status);
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
}
