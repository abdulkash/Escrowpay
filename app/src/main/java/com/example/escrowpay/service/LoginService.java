package com.example.escrowpay.service;

import com.example.escrowpay.model.POJO.login.LoginModel;
import com.example.escrowpay.model.POJO.login.LoginResponse;
import com.example.escrowpay.model.POJO.register.Data;
import com.example.escrowpay.model.POJO.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST("auth/login")
    Call<LoginResponse> loginUser(@Body LoginModel data);
}
