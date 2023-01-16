package com.example.spanzuratoarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private EditText etLitera;
    private TextView txtView;
    private Button btnVerifica;
    String[] cuvinte = {"novatoare","escalator", "buchet", "meteo","traduce","liber","cancan","cal","ziar","joc","sport",
    "email"};
    int vietiPierdute = 0;
    int litereGasite = 0;
    int numarCuvant = new Random().nextInt(12);
    private volatile boolean sanctionat = false;
    private volatile boolean castigat = false;
    String[] cuvantCenzurat = {"","","","","","","","","","","","","","",""};
    String[] cuvantNeCenzurat = {"","","","","","","","","","","","","","",""};
    String cuvantDeCenzurat = cuvinte[numarCuvant];
    String testCuvant = "";
    int lungime = cuvinte[numarCuvant].length();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        replaceFragment(new startgame());
        etLitera = findViewById(R.id.etLitera);
        txtView = findViewById(R.id.tvCuvant);
        btnVerifica = findViewById(R.id.btnVerifica);
        for(int i = 0; i < lungime; i++){
            cuvantNeCenzurat[i] = String.valueOf(cuvantDeCenzurat.charAt(i));
            Log.d(TAG, "onCreate: "+ cuvantNeCenzurat[i]);
        }
        for(int i = 0; i < lungime; i++) {
            if(i == 0) cuvantCenzurat[i] = String.valueOf(cuvantDeCenzurat.charAt(0));
            else if(i == lungime-1) cuvantCenzurat[i] = String.valueOf(cuvantDeCenzurat.charAt(lungime-1));
            else cuvantCenzurat[i] = " _ ";
            testCuvant += String.valueOf(cuvantCenzurat[i]);
        }
        txtView.setText(testCuvant);
    }
    public void onClickEnter(View view) {
        if(vietiPierdute == 6 || castigat == true) {
            Intent StartAgain = new Intent(this, MainActivity.class);
            startActivity(StartAgain);
            return;
        }
        String literas = etLitera.getText().toString();
        char litera = literas.charAt(0);
        String Litara = String.valueOf(litera);
        IncearcaCaracter(Litara);
    }

    private void IncearcaCaracter(String litera) {
        testCuvant = "";
        for(int i = 0; i < lungime; i++) {
            if(litera.equals(cuvantNeCenzurat[i])) {
                cuvantCenzurat[i] = litera;
                litereGasite++;
                sanctionat = true;
            }
            if(i != 0 && i != lungime-1 && cuvantCenzurat[i].equals(" _ ") && !sanctionat){
                sanctionat = true;
                vietiPierdute++;
                if(vietiPierdute == 1) replaceFragment(new vietiPierdute1());
                else if(vietiPierdute == 2) replaceFragment(new vietiPierdute2());
                else if(vietiPierdute == 3) replaceFragment(new vietiPierdute3());
                else if(vietiPierdute == 4) replaceFragment(new vietiPierdute4());
                else if(vietiPierdute == 5) replaceFragment(new vietiPierdute5());
                else if(vietiPierdute == 6) {
                    replaceFragment(new vietiPierdute6());
                    txtView.setText(""+ cuvinte[numarCuvant]);
                    btnVerifica.setText("Play Again");
                    return;
                }
                cuvantCenzurat[i] = " _ ";
            }
            testCuvant += String.valueOf(cuvantCenzurat[i]);
        }
        txtView.setText(testCuvant);
        CheckGame();
        etLitera.setText("");
    }

    private void CheckGame() {
        int lung = 0;
        for(int i = 0; i < lungime; i++) {
            if(cuvantCenzurat[i] != " _ ") lung++;
        }
        if(lung == lungime) {
            Toast.makeText(getApplicationContext(),"Felicitari! Ai castigat!", Toast.LENGTH_LONG).show();
            castigat = true;
            btnVerifica.setText("New Game");
        }
        sanctionat = false;
        litereGasite = 0;
    }

    private void replaceFragment(Fragment fragmentParam) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        fragTransaction.replace(R.id.frameLayout, fragmentParam);
        fragTransaction.commit();

    }
}