package com.josalv.mycars;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.ListIterator;

public class CarList extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        Intent intent = new Intent (getApplicationContext(), CarList.class);
        startActivityForResult(intent, 0);

       /* DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();

        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, DbHelper.getAllCars(db));
        //adaptador = new Adaptador(this, getCar());
        lvItems.setAdapter(adaptador);
        */
    }


    /*public ArrayList<Car> getCar(){
        Car car1 = new Car("hola","hola","hola","negro","prueba");
        Car car2 = new Car("holfa","hofla","hogla","neggro","pruebga");

        ArrayList<Car> coches= new ArrayList<>();
        coches.add(car1);
        coches.add(car2);
        return coches;

    }*/


}
