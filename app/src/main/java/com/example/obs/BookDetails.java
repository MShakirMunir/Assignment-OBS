package com.example.obs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class BookDetails extends AppCompatActivity {

    TextView bookName,className,autherName,description,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        bookName = findViewById(R.id.book_name1);
        className = findViewById(R.id.Class_name1);
        autherName = findViewById(R.id.auther_name1);
        description = findViewById(R.id.Description1);
        location = findViewById(R.id.Locaation1);

        Intent intent=getIntent();
      String gotBookName =  intent.getStringExtra("gotBookName");
        String gotClassName = intent.getStringExtra("gotClassName");
        String gotAutherName =intent.getStringExtra("gotAutherName");
        String gotDescription =intent.getStringExtra("gotDescription");
        String gotLocation = intent.getStringExtra("gotLocation");



        bookName.setText(gotBookName);
        className.setText(gotClassName);
        autherName.setText(gotAutherName);
        description.setText(gotDescription);
        location.setText(gotLocation);



    }
}
