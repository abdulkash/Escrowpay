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
import com.example.escrowpay.model.POJO.register.Data;
import com.example.escrowpay.model.POJO.register.RegisterResponse;
import com.example.escrowpay.service.LoginService;
import com.example.escrowpay.service.RegisterService;
import com.example.escrowpay.service.ServiceBuilder;
import com.example.escrowpay.session_manager.SessionManager;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    SessionManager sessionManager;

    RegisterResponse registerResponse;

    RegisterService service;

    LoginService loginService;

    CustomDiag customDiag;

    List<String> username_error;
    List<String> email_error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        sessionManager = new SessionManager(getApplicationContext());
        customDiag = new CustomDiag(this);
        service = ServiceBuilder.getRetrofit().create(RegisterService.class);
        loginService = ServiceBuilder.getRetrofit().create(LoginService.class);

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

            String str_firstName = firstName.getEditText().getText().toString();
            String str_lastname = lastName.getEditText().getText().toString();
            String str_phn = phone.getEditText().getText().toString();
            String str_email = email.getEditText().getText().toString();
            String str_username = username.getEditText().getText().toString();
            String str_password = password.getEditText().getText().toString();
            String str_conpassword = confirmPassword.getEditText().getText().toString();

            if (TextUtils.isEmpty(str_firstName) ||TextUtils.isEmpty(str_lastname) || TextUtils.isEmpty(str_phn) || TextUtils.isEmpty(str_email)
                    || TextUtils.isEmpty(str_username) || TextUtils.isEmpty(str_conpassword) || TextUtils.isEmpty(str_password) || TextUtils.isEmpty(str_conpassword) ){
                firstName.setError("field required");
                lastName.setError("field required");
                phone.setError("field required");
                email.setError("field required");
                username.setError("field required");
                password.setError("field required");
                confirmPassword.setError("field required");

            }else if (!str_conpassword.equals(str_password)){
                confirmPassword.setError("passwords don't match");
            }else {
                customDiag.loadingDialogue();
                Data data = new Data(str_firstName,str_lastname,str_email,str_username,str_phn,str_password,str_conpassword);
                service.registerUser(data).enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()){
                             registerResponse = response.body();
//
                            Log.d("register response", "onResponse: "+ registerResponse.getSuccess());

                            LoginModel model = new LoginModel(str_email,str_password);
                            loginService.loginUser(model).enqueue(new Callback<LoginResponse>() {
                                @Override
                                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                    LoginResponse loginResponse = response.body();
                                    Common common = new Common();
                                    String token = loginResponse.getData().getToken();
                                    common.setToken(token);

                                    sessionManager.createLoginSession(str_username,str_email);
                                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                                    finish();
                                    //Log.d("Token", "onResponse: "+ common.getToken());
                                }

                                @Override
                                public void onFailure(Call<LoginResponse> call, Throwable t) {
                                    Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                            customDiag.dismiss();
                        }else if (response.code() == 422){

                            Gson gson = new Gson();
                            try {
                                registerResponse = gson.fromJson(
                                       response.errorBody().string(),
                                       RegisterResponse.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            username_error = registerResponse.getErrors().getUsername();
                            email_error = registerResponse.getErrors().getEmail();
                            customDiag.dismiss();

                            if (username_error != null) {
                               username.setError("The username has already been taken.");
                            }else if (email_error != null){
                              email.setError("The email has already been taken.");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        customDiag.dismiss();
                        Log.d("register error", "onFailure: " + t.getLocalizedMessage());
                    }
                });
//                AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
//
//                LayoutInflater inflater=LayoutInflater.from(this);
//                View register_phone_layout=inflater.inflate(R.layout.verify_email, null);
//                final TextInputLayout verify_txt = register_phone_layout.findViewById(R.id.txt_emailverify);
//                final Button verify = register_phone_layout.findViewById(R.id.btn_verifyemail);
//
//                alertDialog.setView(register_phone_layout);
//                AlertDialog dialog = alertDialog.create();
//                dialog.show();
//
//                verify.setOnClickListener(view1 -> {
//
//
//                });
            }



        });
        nav_login.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

        });
    }

    @Override
    protected void onPause() {
        email.setError(null);
        username.setError(null);
        confirmPassword.setError(null);
        super.onPause();
    }
}