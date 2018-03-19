package com.example.nlhsueh.lucky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_hello;
    Button btn_go;
    int luckyNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.tv_hello);
        btn_go = findViewById(R.id.btn_go);
        Log.i("LIFECYCLE", "Create");
    }


    public void fn_showLuckyNumber (View view) {
        Random r = new Random();
        luckyNumber = r.nextInt(6)+1;
        Log.v("random ", Integer.toString(luckyNumber));
        btn_go.setEnabled(true);
        tv_hello.setText(Integer.toString(luckyNumber));
    }

    public void fn_goNextAct (View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("n", luckyNumber);
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 111:
                int like = data.getIntExtra("Like",1);
                if (like == 1) {
                    tv_hello.setText("Happy~~");
                }
                else {
                    tv_hello.setText("Try again!");
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE", "Destroy");
    }
}