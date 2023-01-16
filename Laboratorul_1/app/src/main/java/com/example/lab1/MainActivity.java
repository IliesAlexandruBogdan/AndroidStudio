package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public void ResetextViews() {
        TextView tvName = findViewById(R.id.tvName);
        TextView tvLastName = findViewById(R.id.tvLastName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvComplete = findViewById(R.id.tvComplete);
        EditText etName = findViewById(R.id.etName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etEmail = findViewById(R.id.etEmail);
        etName.getText().clear();
        etLastName.getText().clear();
        etEmail.getText().clear();
        tvName.setText("");
        tvLastName.setText("");
        tvEmail.setText("");
        tvComplete.setText("");
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setVisibility(View.GONE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResetextViews();
    }
    public void onClickRegister(View view) {
        TextView tvName = findViewById(R.id.tvName);
        TextView tvLastName = findViewById(R.id.tvLastName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvComplete = findViewById(R.id.tvComplete);
        EditText etName = findViewById(R.id.etName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etEmail = findViewById(R.id.etEmail);
        String Name = etName.getText().toString();
        String LastName = etLastName.getText().toString();
        String Email = etEmail.getText().toString();
        tvName.setText("Name: "+Name);
        tvLastName.setText("Last Name: "+LastName);
        tvEmail.setText("Email: "+Email);
        tvComplete.setText("Registration complete!");
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setVisibility(View.VISIBLE);
    }
    public void onClickReset(View view) {
        ResetextViews();
    }
}