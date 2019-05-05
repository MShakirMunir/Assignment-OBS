package com.example.obs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context contex;
     List<MyModel> arrBooks;
     LayoutInflater layoutInflater;
     MyViewHolder myViewHolder;

    public MyAdapter(Context contex, List<MyModel> arrBooks) {
        this.contex = contex;
        this.arrBooks = arrBooks;
        this.layoutInflater=LayoutInflater.from(contex);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.custom_view, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        MyModel model=arrBooks.get(i);

     String gotBookName=   model.getBookName();
     String gotAutherName = model.getAutherName();
        String gotClassName =   model.getClassName();
        String gotDescription = model.getDescription();
        String gotLocation = model.getLocation();

        myViewHolder.tv.setText(gotBookName); //set book name to list view

       final int position= myViewHolder.getAdapterPosition(); //get position when tapped

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { //handle click event on list items
            @Override
            public void onClick(View v) {

                MyModel model=arrBooks.get(position);

                String gotBookName=   model.getBookName();
                String gotAutherName = model.getAutherName();
                String gotClassName =   model.getClassName();
                String gotDescription = model.getDescription();
                String gotLocation = model.getLocation();

                //movement
                Intent intent=new Intent(contex, BookDetails.class);
                intent.putExtra("gotBookName",gotBookName);
                intent.putExtra("gotAutherName",gotAutherName);
                intent.putExtra("gotClassName",gotClassName);
                intent.putExtra("gotDescription",gotDescription);
                intent.putExtra("gotLocation",gotLocation);
                contex.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrBooks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tv;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.book);
        }
    }

}
