package nlhsueh.implicitactdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fn_call(View view) {
        Uri uri = Uri.parse(
                "tel:9487948");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }

    public void fn_mail(View view) {
        Uri uri = Uri.parse(
                "mail:who_are_you@mail.fcu.edu.tw");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(intent);
    }

    public void fn_web(View view) {
        Uri uri = Uri.parse(
                "http://www.google.com.tw");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }
}
