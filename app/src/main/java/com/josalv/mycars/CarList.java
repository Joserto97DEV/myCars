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

    }


}
