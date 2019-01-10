package com.josalv.mycars;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DbHelper cardbh = new DbHelper(this);
        SQLiteDatabase db = cardbh.getWritableDatabase();
        List<Car> cars = DbHelper.getAllCars(db);

        if (!cars.isEmpty()) {
            setContentView(R.layout.activity_car_list);

            final ListView lvItems;
            final Adaptador adaptador;

            lvItems = (ListView) findViewById(R.id.lvItems);

            adaptador = new Adaptador(this, DbHelper.getAllCars(db));
            lvItems.setAdapter(adaptador);

            lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity.this, CarDetail.class);
                    Car currentCar = (Car) adaptador.getItem(i);

                    intent.putExtra("carID", currentCar.getId());
                    startActivity(intent);
                }
            });
        } else {
            setContentView(R.layout.activity_no_cars);
        }
    }

}