package com.josalv.mycars;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CarDetail extends AppCompatActivity {

    private SQLiteDatabase db = null;

    private String carID;

    private TextView tvID;
    private TextView tvMarca;
    private TextView tvColor;
    private TextView tvDescripcion;
    private TextView tvTipo;
    private Button btnDelete;
    private Button btnEdit;

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


        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        // Obtenemos el ID item que habiamos clickado
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            carID = bundle.getString("carID");
        }

        // Obtenemos el coche de la base de datos:
        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
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

        // Asignamos una funcion al boton de borrar:
        btnDelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try{
                    // Borramos el coche
                    DbHelper.deleteByID(db, carID);
                    Toast.makeText(CarDetail.this, "Borrado correctamente", Toast.LENGTH_SHORT).show();
                    // Volvemos a MainActivity
                    Intent intent = new Intent(CarDetail.this, MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    // No se ha podido borrar el coche
                    Toast.makeText(CarDetail.this, "ERROR: No se ha podido borrar", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

}
