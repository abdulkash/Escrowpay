package com.example.escrowpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.escrowpay.common.Common;
import com.example.escrowpay.design.CustomDiag;
import com.example.escrowpay.model.POJO.login.LoginModel;
import com.example.escrowpay.model.POJO.login.LoginResponse;
import com.example.escrowpay.model.POJO.register.RegisterResponse;
import com.example.escrowpay.service.LoginService;
import com.example.escrowpay.service.ServiceBuilder;
import com.example.escrowpay.session_manager.SessionManager;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private Button nav_signup;
    private Button forgot_pass;

    private TextInputLayout email;
    private TextInputLayout password;
    String str_email;
    String str_password;

    LoginService service;
    CustomDiag diag;
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        service = ServiceBuilder.getRetrofit().create(LoginService.class);
        diag = new CustomDiag(this);

        login = findViewById(R.id.log_btn);
        nav_signup = findViewById(R.id.navigate_register);
        forgot_pass = findViewById(R.id.fogot_pass);
        email = findViewById(R.id.log_email);
        password = findViewById(R.id.log_password);



        login.setOnClickListener(view -> {
            str_email = email.getEditText().getText().toString();
            str_password = password.getEditText().getText().toString();

            if (TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_password)) {
                email.setError("field required");
                password.setError("field required");
            }
          else {
              diag.loadingDialogue();
                LoginModel data = new LoginModel(str_email,str_password);
                service.loginUser(data).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                             loginResponse = response.body();
                            Common common = new Common();
                            common.setToken(loginResponse.getData().getToken());

                            SessionManager sessionManager = new SessionManager(LoginActivity.this);
                            sessionManager.createLoginSession(str_email,str_email);

                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();

                            Log.d("login token", "onResponse: "+ common.getToken());
                        }else if (response.code() == 401){
                            Gson gson = new Gson();
                            try {
                                loginResponse = gson.fromJson(
                                        response.errorBody().string(),
                                        LoginResponse.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Log.d("login error", "onResponse: "+ loginResponse.getMessage());
                        }
                        diag.dismiss();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                    diag.dismiss();
                        Log.d("retrofit error", "onFailure: "+t.getLocalizedMessage());
                    }
                });

//
            }
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