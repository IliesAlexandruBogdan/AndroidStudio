package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView tvRezultat;
    public EditText etNrA;
    public EditText etNrB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String rezultat = getIntent().getStringExtra("sendRezultat");
        tvRezultat = findViewById(R.id.tvRezultat);
        tvRezultat.setText("Rezultatul este egal cu: "+rezultat);

    }
    public void onClickSum(View view) {
        Intent intent_aduna = new Intent(this, MainActivity2.class);

        intent_aduna.putExtra("action", "0");
        etNrA = findViewById(R.id.etNrA);
        etNrB = findViewById(R.id.etNrB);
        String nrA = etNrA.getText().toString();
        String nrB = etNrB.getText().toString();
        intent_aduna.putExtra("numberA", nrA);
        intent_aduna.putExtra("numberB", nrB);

        startActivity(intent_aduna);

        Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
    }
    public void OnClickSubtration(View view) {
        Intent intent_aduna = new Intent(this, MainActivity2.class);

        intent_aduna.putExtra("action", "1");
        etNrA = findViewById(R.id.etNrA);
        etNrB = findViewById(R.id.etNrB);
        String nrA = etNrA.getText().toString();
        String nrB = etNrB.getText().toString();
        intent_aduna.putExtra("numberA", nrA);
        intent_aduna.putExtra("numberB", nrB);

        startActivity(intent_aduna);

        Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
    }
    public void onClickMultiple(View view) {
        Intent intent_aduna = new Intent(this, MainActivity2.class);

        intent_aduna.putExtra("action", "2");
        etNrA = findViewById(R.id.etNrA);
        etNrB = findViewById(R.id.etNrB);
        String nrA = etNrA.getText().toString();
        String nrB = etNrB.getText().toString();
        intent_aduna.putExtra("numberA", nrA);
        intent_aduna.putExtra("numberB", nrB);

        startActivity(intent_aduna);

        Toast.makeText(getApplicationContext(), "Calculating...", Toast.LENGTH_SHORT).show();
    }
}