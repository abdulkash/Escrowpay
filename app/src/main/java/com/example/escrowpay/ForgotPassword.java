package com.example.escrowpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotPassword extends AppCompatActivity {

    TextInputLayout resetEmail;
    Button resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        resetEmail = findViewById(R.id.reset_email);
        resetButton = findViewById(R.id.btn_reset);

        resetButton.setOnClickListener(view ->{
            Toast.makeText(this, "Resetting Email", Toast.LENGTH_SHORT).show();
        });
    }
}