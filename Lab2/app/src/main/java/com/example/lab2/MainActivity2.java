package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    public void Operation(int actions, int nrA, int nrB) {
        switch (actions) {
            case 0: {
                int rezultat = nrA + nrB;
                String rez = String.valueOf(rezultat);
                Intent sendRezultat = new Intent(this, MainActivity.class);
                sendRezultat.putExtra("sendRezultat", rez);
                startActivity(sendRezultat);
                break;
            }
            case 1: {
                int rezultat = nrA - nrB;
                String rez = String.valueOf(rezultat);
                Intent sendRezultat = new Intent(this, MainActivity.class);
                sendRezultat.putExtra("sendRezultat", rez);
                startActivity(sendRezultat);
                break;
            }
            case 2: {
                int rezultat = nrA * nrB;
                String rez = String.valueOf(rezultat);
                Intent sendRezultat = new Intent(this, MainActivity.class);
                sendRezultat.putExtra("sendRezultat", rez);
                startActivity(sendRezultat);
                break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String action = getIntent().getStringExtra("action");
        String nrA = getIntent().getStringExtra("numberA");
        String nrB = getIntent().getStringExtra("numberB");
        int numberA = Integer.parseInt(nrA);
        int numberB = Integer.parseInt(nrB);
        int actions = Integer.parseInt(action);
        Operation(actions, numberA, numberB);
    }
}