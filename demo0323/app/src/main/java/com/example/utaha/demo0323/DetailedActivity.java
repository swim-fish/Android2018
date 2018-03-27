package com.example.utaha.demo0323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Intent intent = getIntent();
        String  food = intent.getStringExtra("food");
        String  place = intent.getStringExtra("place");
        int mFoods_img = Integer.parseInt(intent.getStringExtra("mFoods_img"));

        TextView textview_food = (TextView) findViewById(R.id.detailed_textView);
        textview_food.setText(food);

        TextView textview_place = (TextView) findViewById(R.id.detailed_textView2);
        textview_place.setText(place);

        ImageView img = (ImageView) findViewById(R.id.detailed_imageView);
        img.setImageResource(mFoods_img);
    }
}
