package com.example.obs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {
    EditText fName, lName, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fName = (EditText) findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        email = findViewById(R.id.eMailAddress);
        password = findViewById(R.id.password);
    }

    private void addUser(String f, String l, String e, String p) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference userTable = db.getReference("Users").push();

        userTable.child("firstName").setValue(f);
        userTable.child("lastName").setValue(l);
        userTable.child("email").setValue(e);
        userTable.child("password").setValue(p);
    }

    public void signUp(View view) {
        String firstName = fName.getText().toString();
        String lastName = lName.getText().toString();
        String e = email.getText().toString();
        String pass = password.getText().toString();

        if (firstName.isEmpty()) {
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show();
            fName.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(fName, InputMethodManager.SHOW_IMPLICIT);
        } else if (lastName.isEmpty()) {
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_SHORT).show();
            lName.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(lName, InputMethodManager.SHOW_IMPLICIT);
        } else if (e.isEmpty()) {
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
            addUser(firstName, lastName, e, pass);
            Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    private void clear(){
        fName.setText(null);
        lName.setText(null);
        email.setText(null);
        password.setText(null);
    }
}
