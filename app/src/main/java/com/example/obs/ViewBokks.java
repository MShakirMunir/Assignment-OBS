package com.example.obs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextThemeWrapper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/*
* step 1: make a custom_view, integrate recyclerView and fetch data from DB into variables.
* step 2: make a Model class and pass all data into it
* step 3: make contructor and getter/setter in Model class
* step 4: pass model class into an arrayList of type <Model>
* step 5: create an Adapter class and (a sub class ViewHolder)  and pass arrayList to it
 * step 6: attach our cutom view to MyViewHolder class */
public class ViewBokks extends AppCompatActivity {

    RecyclerView RV;

    MyModel myModel;
    Context context;
    MyAdapter adapter;
    List<MyModel> arrBooks = new ArrayList<>();

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bokks);
        context = this;

        RV = findViewById(R.id.RV);


        RV.setLayoutManager(new LinearLayoutManager(context));

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);

        fetchDB();

    }

    void fetchDB() {


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("ALL Books");

        progressDialog.show();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String bookName = ds.child("bookName").getValue(String.class);
                    String className = ds.child("className").getValue(String.class);
                    String autherName = ds.child("autherName").getValue(String.class);
                    String description = ds.child("description").getValue(String.class);
                    String location = ds.child("location").getValue(String.class);

                    myModel = new MyModel(bookName, className, autherName, description, location);
                    arrBooks.add(myModel);
                }

                adapter = new MyAdapter(context, arrBooks);
                RV.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        progressDialog.dismiss();
    }

}
