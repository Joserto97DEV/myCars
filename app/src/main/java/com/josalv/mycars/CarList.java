package com.josalv.mycars;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ListIterator;

public class CarList extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();

        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, cardbh.getAllCars(db));

        lvItems.setAdapter(adaptador);
    }
}
