package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Handler mainHandler = new Handler();
    private Button btn1;
    private volatile boolean gameStatus = false;
    private TextView txtView2;
    private EditText etIncearca;
    int numar, nr1, nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnStart);
        txtView2 = findViewById(R.id.txtView2);
        etIncearca = findViewById(R.id.etNumar);
        txtView2.setText("");
    }
    public void onClickIncearca(View view){
        if(!gameStatus)
            return;
        nr1 = Integer.parseInt(etIncearca.getText().toString());
        if(nr1 == numar){
            gameStatus =  false;
            txtView2.setText("Congratulations! You have guess the number befor computer, you win!");
            Toast.makeText(getApplicationContext(),"You win!!", Toast.LENGTH_LONG).show();
            btn1.setText("Start");
        }else{
            etIncearca.setText("");
            Toast.makeText(getApplicationContext(),"Mai incearca!", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickStart(View view) {
        if(gameStatus)
            return;
        numar = new Random().nextInt(10);
        Log.d(TAG, "onClickStart: "+numar);
        TextView test = findViewById(R.id.txtView);
        gameStatus = true;
        btn1.setText("Game Started");
        RunThread thread = new RunThread(10);
        txtView2.setText("");
        etIncearca.setText("");
        new Thread(thread).start();
    }
    class RunThread implements Runnable {
        int seconds;
        RunThread(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {
            do {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        nr2 = new Random().nextInt(10);
                        if(numar == nr2){
                            txtView2.setText("You lose! The computer was guess the number first!");
                            btn1.setText("Start");
                            gameStatus = false;
                        }
                    }
                });
                Log.d(TAG, "run: "+nr2);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (gameStatus);
        }
    }
}