package com.example.obs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
    }

    public void add_book(View view) {
        startActivity(new Intent(Home1.this, AddBook.class));

    }

    public void view_book(View view) {
        startActivity(new Intent(Home1.this, ViewBokks.class));

    }
}
