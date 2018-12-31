package com.josalv.mycars;


import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.*;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ProgressBar;
import android.util.Log;

import android.os.AsyncTask;
import android.app.Fragment;

/**
 * @author Jose Alberto del Val
 * @author Alvaro Velasco
 */
public class AddCarFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private static final String TAG = "FragmentActivity";

    EditText brand;
    EditText model;
    EditText color;
    Spinner tipo;
    EditText description;

    Button button_add;


    //ProgressBar
    private ProgressBar progressBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_car, container, false);

        super.onCreate(savedInstanceState);

        // Enlazar views
        brand = (EditText) view.findViewById(R.id.brand);
        model = (EditText) view.findViewById(R.id.model);
        color = (EditText) view.findViewById(R.id.color);
        tipo = (Spinner) view.findViewById(R.id.spinner_type);
        description = (EditText) view.findViewById(R.id.description);

        button_add = (Button) view.findViewById(R.id.button_add);
        button_add.setOnClickListener(this);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        return view;
    }



    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    // Función llamada al pulsar el botón
    public void onClick(View v) {
        String sbrand = brand.getText().toString();
        String smodel = model.getText().toString();
        String scolor = color.getText().toString();
        String stipo = tipo.getSelectedItem().toString();
        String sdescription = description.getText().toString();

        //ABRIR INSTANCIA DE LA BASE DE DATOS AQUí

        Log.d(TAG, "onClicked");

        if(sbrand.isEmpty()||smodel.isEmpty()||scolor.isEmpty()||sdescription.isEmpty()){
            Toast.makeText(AddCarFragment.this.getActivity(), "Es necesario rellenar todos los campos", Toast.LENGTH_LONG).show();
        } else {

            String sql = "SELECT * FROM car WHERE MARCA ="+sbrand+"AND MODELO ="+smodel;
            //db.execSQL(sql);


            //IF se encuentra algún resultado de la anteriro consulta, notificar que ya existe, ELSE insertar.

            //Mostramos el progressBar al hacer clic
            progressBar.setVisibility(View.VISIBLE);
            button_add.setVisibility(View.INVISIBLE);
            //new PostTask().execute(sbrand, smodel, scolor, sdescription);
        }


    }

    // Guardar en la BD de manera asíncrona, igual que hacíamos con twitter
    private final class PostTask extends AsyncTask<String, Void, String> {

        // Llamada al empezar
        @Override
        protected String doInBackground(String... params) {
            try {
            Thread.sleep(2000);}
            catch(Exception e){

            }
            return null;
        }

        // Llamada cuando la actividad en background ha terminado
        @Override
        protected void onPostExecute(String result) {
            // Acción al completar la actualización del estado
            super.onPostExecute(result);
            progressBar.setVisibility(View.GONE);
            button_add.setVisibility(View.VISIBLE);
            Toast.makeText(AddCarFragment.this.getActivity(), "Añadido correctamente.", Toast.LENGTH_LONG).show();
        }
    }



}
