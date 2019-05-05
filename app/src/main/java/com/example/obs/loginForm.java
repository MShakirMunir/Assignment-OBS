package com.example.obs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginForm extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        email = findViewById(R.id.eMail);
        password = findViewById(R.id.password);
    }

    public void signUp(View v) {
        startActivity(new Intent(loginForm.this, signUp.class));
    }

    public void goToHome1(View v) {
        final String e = email.getText().toString();
        final String pass = password.getText().toString();
        if (e.isEmpty()) {
            Toast.makeText(this, "Enter email address", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(email, InputMethodManager.SHOW_IMPLICIT);
        } else if (pass.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
        } else {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference userTable = db.getReference("Users");

            userTable.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String dbEmail = ds.child("email").getValue(String.class);
                        String dbPass = ds.child("password").getValue(String.class);

                        if (e.equals(dbEmail) && pass.equals(dbPass)) {
                            startActivity(new Intent(loginForm.this, Home1.class));
                            break;
                        } else {
                            Toast.makeText(loginForm.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
