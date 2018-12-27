package com.josalv.mycars;



import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.*;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.util.Log;

//Comprobación Internet
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//SnackBar





import android.os.AsyncTask;
import android.app.Fragment;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.text.TextUtils;
import android.content.Intent;


/**
 * @author Jose Alberto del Val
 * @author Alvaro Velasco
 */
public class AddCarFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private static final String TAG = "FragmentActivity";

    EditText brand;
    EditText model;
    EditText color;
    EditText description;

    Spinner spynner_type;

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
        String sdescription = description.getText().toString();


        Log.d(TAG, "onClicked");

        //Mostramos el progressBar al hacer clic
        progressBar.setVisibility(View.VISIBLE);
        button_add.setVisibility(View.INVISIBLE);

        if(sbrand.isEmpty()||smodel.isEmpty()||scolor.isEmpty()||sdescription.isEmpty()){
            Toast.makeText(AddCarFragment.this.getActivity(), "Es necesario rellenar todos los campos", Toast.LENGTH_LONG).show();
        }

        /*else{
            new PostTask().execute(status);

        }*/


    }

    // Guardar en la BD de manera asíncrona, igual que hacíamos con twitter

    private final class PostTask extends AsyncTask<String, Void, String> {
        // Llamada al empezar
        @Override
        protected String doInBackground(String... params) {


            return null;
        }
        // Llamada cuando la actividad en background ha terminado
        @Override
        protected void onPostExecute(String result) {
            // Acción al completar la actualización del estado
            super.onPostExecute(result);
            progressBar.setVisibility(View.GONE);
            button_add.setVisibility(View.VISIBLE);
        }
    }



}
