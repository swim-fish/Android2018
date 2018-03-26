package com.example.utaha.demo0326;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                        textView.setText("choice: 1");
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                        textView.setText("choice: 2");
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                        textView.setText("choice: 3");
                        break;
                }

            }
        });
    }
}
