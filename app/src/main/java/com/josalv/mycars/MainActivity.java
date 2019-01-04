package com.josalv.mycars;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_UPDATE_DELETE_CAR = 0 ;
    private static final String EXTRA_CAR_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  FRAGMENT DE AÑADIR NUEVO COCHE
/*

         if (savedInstanceState == null) {
            // Crear un fragment
            AddCarFragment fragment = new AddCarFragment(); getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, fragment.getClass().getSimpleName()).commit();
        }
*/

        setContentView(R.layout.activity_car_list);

        DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();
         final ListView lvItems;
         final Adaptador adaptador;

        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, DbHelper.getAllCars(db));
        lvItems.setAdapter(adaptador);



         // ArrayAdapter<Car> mAdapter = new ArrayAdapter<Car>(MainActivity.this,
         //        android.R.layout.simple_list_item_1,
         //        DbHelper.getAllCars(db));

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CarDetail.class);
                Car currentCar = (Car) adaptador.getItem(i);

                Toast.makeText(MainActivity.this, (currentCar.getMarca() + ": " + currentCar.getId()), Toast.LENGTH_SHORT).show();

                intent.putExtra("carID", currentCar.getId());
                startActivity(intent);
            }
        });

        //lvItems.setAdapter(mAdapter);


    }



}
