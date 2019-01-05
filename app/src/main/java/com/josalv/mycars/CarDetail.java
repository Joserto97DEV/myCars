package com.josalv.mycars;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CarDetail extends AppCompatActivity {

    private SQLiteDatabase db = null;

    private Car c;
    private String carID;
    private int edit_or_save = 0;

    private TextView tvID;
    private TextView tvMarca;
    private TextView tvModelo;
    private TextView tvColor;
    private TextView tvDescripcion;
    private TextView[] tvs = {tvMarca, tvModelo, tvColor, tvDescripcion};

    private EditText etMarca;
    private EditText etModelo;
    private EditText etColor;
    private EditText etDescripcion;
    private EditText[] ets = {etMarca, etModelo, etColor, etDescripcion};


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

        // Declaramos los elementos de texto:
        tvID          = (TextView) findViewById(R.id.tvID);
        tvMarca       = (TextView) findViewById(R.id.tvMarca);
        tvModelo      = (TextView) findViewById(R.id.tvModelo);
        tvColor       = (TextView) findViewById(R.id.tvColor);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        // Declaramos los elementos editables:
        etMarca       = (EditText) findViewById(R.id.etMarca);
        etModelo      = (EditText) findViewById(R.id.etModelo);
        etColor       = (EditText) findViewById(R.id.etColor);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        // Declaramos los botones:
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
        try {
           c = DbHelper.findByID(db, carID);
        } catch (Exception e) {
            c = null;
        }

        // Cargamos los valores:
        if (c!=null) {

            // En los label
            tvID.setText(c.getId());
            tvMarca.setText(c.getMarca());
            tvModelo.setText(c.getModelo());
            tvColor.setText(c.getColor());
            //tvDescripcion.setText(c.getDescripcion());

            // En los editables
            etMarca.setText(c.getMarca());
            etModelo.setText(c.getModelo());
            etColor.setText(c.getColor());
            //etDescripcion.setText(c.getDescripcion());

        }


        btnEdit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (edit_or_save == 0) {
                    // Pasamos a editar
                    changeToEdit();
                } else {

                    // Recogemos los valores:
                    String sMarca  = etMarca.getText().toString();
                    String sModelo = etModelo.getText().toString();
                    String sColor  = etColor.getText().toString();
                    String sDescripcion = etDescripcion.getText().toString();

                    // Comprobamos que los campos son válidos:
                    if (!sMarca.isEmpty() && !sModelo.isEmpty() && !sColor.isEmpty() && !sDescripcion.isEmpty()) {

                        // Creamos el nuevo coche
                        Car newcar = new Car(etMarca.getText().toString(),
                                etModelo.getText().toString(),
                                c.getTipo(),
                                etColor.getText().toString(),
                                etDescripcion.getText().toString());

                        // Borramos el viejo de la BD
                        DbHelper.deleteByID(db, carID);

                        // Guardamos el nuevo
                        c = newcar;
                        DbHelper.saveDb(db, c);

                        // Volvemos al estado inicial
                        changeToEdit();

                        // Volvemos al ActivityMain
                        Intent intent = new Intent(CarDetail.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        // No se puede actualizar
                        Toast.makeText(CarDetail.this, "No puede haber campos vacios", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Asignamos una funcion al boton de borrar:
        btnDelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(edit_or_save == 1) {
                    try {
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
                } else {
                    changeToEdit();
                }
            }
        });
    }   // Fin de onCreate()

    /**
     * Función que cambia el tipo de vista en función de si se está editando o no.
     */
    private void changeToEdit(){
        if (edit_or_save == 0){
            // Ponemos visibilidad a los editables
            for(TextView t : tvs){
                t.setVisibility(View.INVISIBLE);
            }
            for(EditText e : ets){
                e.setVisibility(View.VISIBLE);
            }
            btnEdit.setText("Confirmar");
            btnDelete.setText("Cancelar");
            edit_or_save = 1;
        } else {
            // Ponemos visibilidad a los fijos
            for(TextView t : tvs){
                t.setVisibility(View.VISIBLE);
            }
            for(EditText e : ets){
                e.setVisibility(View.INVISIBLE);
            }
            btnEdit.setText("Editar");
            btnDelete.setText("Borrar");
            edit_or_save = 0;
        }
    }
}
