package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> ourMembers;
    private RecyclerView ourRecyclerView;
    private Random nr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourRecyclerView =  findViewById(R.id.mainRecycleView);
        ourMembers = new ArrayList<String>();

        RecycleAdapter ourListAdapter = new RecycleAdapter(ourMembers);
        RecyclerView.LayoutManager ourLayoutManager = new LinearLayoutManager(getApplicationContext());
        ourRecyclerView.setLayoutManager(ourLayoutManager);
        ourRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ourRecyclerView.setAdapter(ourListAdapter);

    }
    public void onClickAdd(View view) {
        TextView etNume = findViewById(R.id.etNume);
        TextView etPrenume = findViewById(R.id.etPrenume);
        String nume = etNume.getText().toString();
        String prenume = etPrenume.getText().toString();
        ourMembers.add(nume+" "+prenume);
        RecycleAdapter ourListAdapter = new RecycleAdapter(ourMembers);
        ourRecyclerView.setAdapter(ourListAdapter);
        ourListAdapter.notifyItemInserted(ourMembers.size()-1);
    }
    public void onClickDelete(View view) {
        if(ourMembers.size()-1 < 0) return;
        ourMembers.remove(ourMembers.size()-1);
        RecycleAdapter ourListAdapter = new RecycleAdapter(ourMembers);
        ourRecyclerView.setAdapter(ourListAdapter);
        ourListAdapter.notifyItemInserted(ourMembers.size()-1);
    }
    private void generateRandomNumbers() {
        nr = new Random();
        for(int i = 0; i < 50; i++)
            ourMembers.add(String.valueOf(nr.nextInt(8999)+1000));
    }
}