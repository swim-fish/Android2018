package com.example.nlhsueh.lucky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.tv_hello);
    }

    public void fn_showLuckyNumber (View view) {
//        Log.i("show lucky", "lucky");
//        Toast.makeText(MainActivity.this,"x", Toast.LENGTH_LONG).show();
        Random r = new Random();
        int i = r.nextInt(6)+1;

        tv_hello.setText(Integer.toString(i));

//        Toast.makeText(MainActivity.this, Integer.toString(i), Toast.LENGTH_SHORT).show();

    }
}
