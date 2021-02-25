package com.example.helloworld;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Dataclass extends RecyclerView.Adapter<Dataclass.myviewholder>
    {
        public static ArrayList<Student> dataholder;
       // private final OnItemClickListener listener;
        Context context;

        public Dataclass(ArrayList<Student> dataholder) {
            this.dataholder = dataholder;
           // this.context=context;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
            return new myviewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myviewholder holder, int position)
        {
            final Student temp=dataholder.get(position);

            holder.Name.setText(dataholder.get(position).getName());
            holder.Rollno.setText(dataholder.get(position).getRollno());

            holder.Rollno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("service","Service stopped");
                    Intent intent= new Intent(v.getContext(),Details.class);

                    intent.putExtra("name",temp.getName());
                    intent.putExtra("rollno",temp.getRollno());
                  intent.putExtra("department",temp.getDepartment());
                   intent.putExtra("emailid",temp.getEmailid());
                   intent.putExtra("position1",position);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);

                  // Bundle bundle = new Bundle();
                  // bundle.putString("name",temp.getName());
                   // bundle.putString("rollno",temp.getRollno());
                   // bundle.putString("department",temp.getDepartment());
                   // bundle.putString("emailid",temp.getDepartment());

                   // Fragment1 mapFragment = new Fragment1();
                   // mapFragment.setArguments(bundle);
                   // v.getContext().startActivity(intent);

                }
            });

        }

        @Override
        public int getItemCount() {
            return dataholder.size();
        }

        class myviewholder extends RecyclerView.ViewHolder
        {

            TextView Name;
            TextView Rollno;

            public myviewholder(@NonNull View itemView)
            {
                super(itemView);

                Name=itemView.findViewById(R.id.t1);
                Rollno=itemView.findViewById(R.id.t2);

            }

            }
        }





