package com.example.escrowpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private Button nav_signup;
    private Button forgot_pass;

    private TextInputLayout email;
    private TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.log_btn);
        nav_signup = findViewById(R.id.navigate_register);
        forgot_pass = findViewById(R.id.fogot_pass);
        email = findViewById(R.id.log_email);
        password = findViewById(R.id.log_password);

        login.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        });
        nav_signup.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
        forgot_pass.setOnClickListener(view -> {
            startActivity(new Intent(this,ForgotPassword.class));
//            Toast.makeText(this,"Coming Soon!!!!",Toast.LENGTH_SHORT).show();
        });

    }
}