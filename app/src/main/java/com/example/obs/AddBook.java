package com.example.obs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBook extends AppCompatActivity {

    EditText bookName ,className, autherName, description, location;
    Button submit;
    String getBookName,getClassName, getAutherName,getDescription,getLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookName=findViewById(R.id.book_name);
        className=findViewById(R.id.Class_name);
        autherName=findViewById(R.id.auther_name);
        description=findViewById(R.id.Description);
        location=findViewById(R.id.Locaation);
        submit=findViewById(R.id.submit);

// Write a message to the database



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 getBookName = bookName.getText().toString();
               getClassName = className.getText().toString();
               getAutherName = autherName.getText().toString();
                getDescription = description.getText().toString();
                getLocation = location.getText().toString();

                if (TextUtils.isEmpty(getBookName)|| TextUtils.isEmpty(getClassName) || TextUtils.isEmpty(getAutherName) || TextUtils.isEmpty(getDescription)|| (TextUtils.isEmpty(getLocation)))
                {
                    Toast.makeText(AddBook.this, "Fill the Empty Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddBook.this, "Submited", Toast.LENGTH_SHORT).show();
                    sendBookToDB();
                    startActivity(new Intent(AddBook.this, Home1.class));

                }

            }
        });
    }

    private void sendBookToDB() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ALL Books").push();

        myRef.child("bookName").setValue(getBookName);
        myRef.child("className").setValue(getClassName);
        myRef.child("autherName").setValue(getAutherName);
        myRef.child("description").setValue(getDescription);
        myRef.child("location").setValue(getLocation);
    }
}
