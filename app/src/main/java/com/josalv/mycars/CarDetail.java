package com.josalv.mycars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CarDetail extends AppCompatActivity {


    private String carID;

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


        tvMarca = (TextView) findViewById(R.id.textView3);

        // Obtenemos el item que habiamos clickado
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            tvMarca.setText(bundle.getString("carID"));
        }

    }
}
