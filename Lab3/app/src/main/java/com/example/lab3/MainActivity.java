package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int idPoza = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new Poza1());
    }
    public void onClickPrev(View view) {
        if(idPoza == 0) idPoza = 5;
        idPoza--;
        switch (idPoza){
            case 0: {
                replaceFragment(new Poza1());
                break;
            }
            case 1: {
                replaceFragment(new Poza2());
                break;
            }
            case 2: {
                replaceFragment(new Poza3());
                break;
            }
            case 3: {
                replaceFragment(new Poza4());
                break;
            }
            case 4: {
                replaceFragment(new Poza5());
                break;
            }
        }
    }
    public void OnClickDetails(View view) {
        Intent intent_tellDetails = new Intent( MainActivity.this, MainActivity2.class);

        String idPozza = String.valueOf(idPoza);

        intent_tellDetails.putExtra("numarPoza", idPozza);

        startActivity(intent_tellDetails);
    }
    public void onClickNext(View view) {
        if(idPoza == 4) idPoza = -1;
        idPoza++;
        switch (idPoza){
            case 0: {
                replaceFragment(new Poza1());
                break;
            }
            case 1: {
                replaceFragment(new Poza2());
                break;
            }
            case 2: {
                replaceFragment(new Poza3());
                break;
            }
            case 3: {
                replaceFragment(new Poza4());
                break;
            }
            case 4: {
                replaceFragment(new Poza5());
                break;
            }
        }
    }
    private void replaceFragment(Fragment fragmentParam) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        fragTransaction.replace(R.id.frameLayout, fragmentParam);
        fragTransaction.commit();

    }
}