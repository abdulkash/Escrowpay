package com.example.escrowpay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private Button next;
    private Button nav_login;

    TextInputLayout firstName;
    TextInputLayout lastName;
    TextInputLayout phone;
    TextInputLayout email;
    TextInputLayout username;
    TextInputLayout password;
    TextInputLayout confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        next = findViewById(R.id.reg_btn);
        nav_login = findViewById(R.id.navigate_login);
        firstName = findViewById(R.id.reg_firstname);
        lastName = findViewById(R.id.reg_lastname);
        phone = findViewById(R.id.reg_phn);
        email = findViewById(R.id.reg_email);
        username = findViewById(R.id.reg_username);
        password = findViewById(R.id.reg_password);
        confirmPassword = findViewById(R.id.reg_conpassword);

        next.setOnClickListener(view -> {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

            LayoutInflater inflater=LayoutInflater.from(this);
            View register_phone_layout=inflater.inflate(R.layout.verify_email, null);
            final TextInputLayout verify_txt = register_phone_layout.findViewById(R.id.txt_emailverify);
            final Button verify = register_phone_layout.findViewById(R.id.btn_verifyemail);

            alertDialog.setView(register_phone_layout);
            AlertDialog dialog = alertDialog.create();
            dialog.show();

            verify.setOnClickListener(view1 -> {
                dialog.dismiss();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
            });
        });
        nav_login.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

        });
    }
}