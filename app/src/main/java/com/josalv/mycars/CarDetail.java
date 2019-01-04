package com.josalv.mycars;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CarDetail extends AppCompatActivity {


    private String carID;

    private TextView tvID;
    private TextView tvMarca;
    private TextView tvColor;
    private TextView tvDescripcion;
    private TextView tvTipo;
    private Button btnBorrar;
    private Button btnModicar;

    private DbHelper dbhelper;

    public CarDetail(){
        // Constructor público vacío
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Declaramos los elementos:
        tvID = (TextView) findViewById(R.id.tvID);
        tvMarca = (TextView) findViewById(R.id.tvMarca);
        tvColor = (TextView) findViewById(R.id.tvColor);


        // Obtenemos el ID item que habiamos clickado
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            carID = bundle.getString("carID");
        }

        // Obtenemos el coche de la base de datos:
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Car c;

        try {
            c = DbHelper.findByID(db, carID);
        } catch (Exception e) {
            c = null;
        }

        // Cargamos los valores:
        if (c!=null) {
            tvID.setText(c.getId());
            tvMarca.setText(c.getMarca());
            tvColor.setText(c.getColor());
        }

    }
}
