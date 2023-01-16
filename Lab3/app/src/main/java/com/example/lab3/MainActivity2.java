package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public void ShowDetails(int id) {
        TextView txtBox = findViewById(R.id.txtPoza);
        switch (id) {
            case 0: {
                txtBox.setText("Image 1: In this photo is an squirrel!");
                break;
            }
            case 1: {
                txtBox.setText("Image 2: In this photo is an people which press an button!");
                break;
            }
            case 2: {
                txtBox.setText("Image 3: In this photo is an duck!");
                break;
            }
            case 3: {
                txtBox.setText("Image 4: In this photo is an smile face from an stone!");
                break;
            }
            case 4: {
                txtBox.setText("Image 5: In this photo is an sady box!");
                break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String idPozza = getIntent().getStringExtra("numarPoza");
        int idPoza = Integer.parseInt(idPozza);

        ShowDetails(idPoza);

    }
    public void onClickGoBack(View view) {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}