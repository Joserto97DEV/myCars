package com.josalv.mycars;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context){
        super(context, CarContract.DB_NAME, null, CarContract.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table %s (%s int primary key, %s text, %s text, %s text, %s text, %s text)",
                CarContract.TABLE,
                CarContract.Column.ID,
                CarContract.Column.MARCA,
                CarContract.Column.MODELO,
                CarContract.Column.TIPO,
                CarContract.Column.COLOR,
                CarContract.Column.DESCRIPCION);



        Log.d(TAG, "onCreate con SQL: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + CarContract.TABLE);
        onCreate(db);
        Log.d(TAG, "onUpgrade");
    }

    public static void saveDb(SQLiteDatabase db, Car car) {
        //INSERTAR BD
        String sql = "INSERT INTO car (MARCA, MODELO, TIPO, COLOR, DESCRIPCION) VALUES " +
                "('" + car.getMarca() + "','" + car.getModelo() + "','"+car.getTipo()+"','"+car.getColor()+"','"+car.getDescripcion()+"') ";
        db.execSQL(sql);
    }

    //Devuelve todos los coches para crear la lista

    public static Car[] getAllCars(SQLiteDatabase db) {
        Cursor cursor =  db.rawQuery("SELECT * FROM car",null );
        List<Car> cars = new ArrayList();
        while(cursor.moveToNext()){
            cars.add(new Car(cursor.getString(0),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5)));
        }

        Car[] carArray = new Car[cars.size()];
        return carArray;
    }



}
