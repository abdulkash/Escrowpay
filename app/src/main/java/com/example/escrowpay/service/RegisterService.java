package com.example.escrowpay.service;

import com.example.escrowpay.model.POJO.register.Data;
import com.example.escrowpay.model.POJO.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RegisterService {

    @Headers("Content-Type:application/json; charset=UTF-8")
    @POST("auth/register")
    Call<RegisterResponse> registerUser(@Body Data data);

}
