package com.example.nlhsueh.lucky;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView img = findViewById(R.id.img_flower);

        Intent intent = getIntent();
        int luckyNum = intent.getIntExtra("n", 1);
        Log.i("show lucky", Integer.toString(luckyNum));


        switch (luckyNum) {
            case 1:
                img.setImageResource(R.drawable.f1);
                break;
            case 2:
                img.setImageResource(R.drawable.f2);
                break;
            case 3:
                img.setImageResource(R.drawable.f3);
                break;
            case 4:
                img.setImageResource(R.drawable.f4);
                break;
            case 5:
                img.setImageResource(R.drawable.f5);
                break;
            default:
                img.setImageResource(R.drawable.f6);
        }
    }

    public void fn_like(View view) {
        Intent i = new Intent();
        i.putExtra("Like", 1);
        setResult(RESULT_OK, i);
        finish();
    }

    public void fn_dislike(View view) {
        Intent i = new Intent();
        i.putExtra("Like", 0);
        setResult(RESULT_OK, i);
        finish();
    }
}
