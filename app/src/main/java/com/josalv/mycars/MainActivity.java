package com.josalv.mycars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getString(R.string.user).equalsIgnoreCase("Albert Einstein")){
            setContentView(R.layout.activity_new_user);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
    private void singin(View view){
        setContentView(R.layout.activity_cars);
    }
}
