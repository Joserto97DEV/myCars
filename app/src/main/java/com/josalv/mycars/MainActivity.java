package com.josalv.mycars;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list);

        DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();
         ListView lvItems;
         Adaptador adaptador;

        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, DbHelper.getAllCars(db));
        lvItems.setAdapter(adaptador);

         //  FRAGMENT DE AÑADIR NUEVO COCHE

         /*
         if (savedInstanceState == null) {
            // Crear un fragment
            AddCarFragment fragment = new AddCarFragment(); getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        }
        */
    }

}
