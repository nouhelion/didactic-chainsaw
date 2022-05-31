package com.careline;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Doctor> list;


    public MyAdapter(Context context, ArrayList<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Doctor doctor = list.get(position);
        holder.fullname.setText(doctor.getFullname());
        holder.location.setText(doctor.getLocation());
        holder.speciality.setText(doctor.getSpeciality());
        holder.status.setText(doctor.getStatus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullname,location,speciality,status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           fullname= itemView.findViewById(R.id.idfullname);
            location = itemView.findViewById(R.id.idlocation);
            speciality = itemView.findViewById(R.id.idspeciality);
            status = itemView.findViewById(R.id.idstatus);

        }
    }

}
