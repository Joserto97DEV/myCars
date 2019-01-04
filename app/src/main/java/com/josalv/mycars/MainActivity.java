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
        //setContentView(R.layout.list_item_car);

        setContentView(R.layout.activity_car_list);

        DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();
         ListView lvItems;
         Adaptador adaptador;

        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, DbHelper.getAllCars(db));
        //adaptador = new Adaptador(this, getCar());
        lvItems.setAdapter(adaptador);
        // Comprobar si la actividad ya ha sido creada con anterioridad
        //if (savedInstanceState == null) {
            // Crear un fragment
           // AddCarFragment fragment = new AddCarFragment(); getFragmentManager()
            //        .beginTransaction()
          //          .add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        //}

    }

}
