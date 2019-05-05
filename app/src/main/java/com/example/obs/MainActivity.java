package com.example.obs;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*new Thread(){
            public void run(){
          try{

              Thread.sleep(4000);
              Intent next = new Intent(MainActivity.this,Home.class);
              startActivity(next);
          }catch (Exception ex){
              Toast.makeText(MainActivity.this,ex.getMessage(), Toast.LENGTH_SHORT).show();
          }
            }
        };*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, loginForm.class));
                finish();
            }
        },4000);
    }

}
