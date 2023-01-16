package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private ArrayList<String> ourMembers;

    public RecycleAdapter(ArrayList<String> ourMembers) {
        this.ourMembers = ourMembers;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView rvTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvTextView = itemView.findViewById(R.id.rvTextView);
        }
    }
    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {
        String curentNumber = ourMembers.get(position);
        holder.rvTextView.setText(curentNumber);
    }

    @Override
    public int getItemCount() {
        return ourMembers.size();
    }
}
