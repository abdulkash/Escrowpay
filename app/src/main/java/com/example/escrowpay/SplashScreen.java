package com.example.escrowpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.escrowpay.session_manager.SessionManager;

public class SplashScreen extends AppCompatActivity {

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sessionManager = new SessionManager(this);
        new Handler().postDelayed(() -> {
            sessionManager.checkLogin();
        },4000);
    }

}