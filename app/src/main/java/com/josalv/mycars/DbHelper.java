package com.josalv.mycars;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
}
