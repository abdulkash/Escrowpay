package com.example.escrowpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.escrowpay.adapter.ImageSliderAdapter;
import com.example.escrowpay.model.ImageSliderModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class StartScreenActivity extends AppCompatActivity {

    private Button login;
    private Button register;

    SliderView sliderView;
    ArrayList<ImageSliderModel> sliderModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        login = findViewById(R.id.start_login);
        register = findViewById(R.id.start_register);
        sliderView = findViewById(R.id.image_slider);

        sliderModels = new ArrayList<>();
        sliderModels.add(new ImageSliderModel(R.drawable.invite,"THE PLACE TO INVITE YOUR FRIENDS","Track details and more importantly to keep a record of our wins and losses."));
        sliderModels.add(new ImageSliderModel(R.drawable.deposit_splash,"DEPOSIT YOUR FUND FOR ESCROW","Track details and more importantly to keep a record of our wins and losses."));
        sliderModels.add(new ImageSliderModel(R.drawable.security,"MAKE AN ESCROW FOR OPPONENT","Make escrow for your security"));
        sliderModels.add(new ImageSliderModel(R.drawable.deal_splash,"EARN FORM DEAL FROM CLIENTS","You win, escrow protects your money."));
        sliderModels.add(new ImageSliderModel(R.drawable.savings,"SAVE YOUR MONEY BE HAPPY","Scammers nightmare, Escrow"));



        ImageSliderAdapter  sliderAdapter = new ImageSliderAdapter(sliderModels);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        login.setOnClickListener(view -> {
            startActivity(new Intent(StartScreenActivity.this,LoginActivity.class));
        });
        register.setOnClickListener(view -> {
            startActivity(new Intent(StartScreenActivity.this,RegisterActivity.class));
        });

    }
}