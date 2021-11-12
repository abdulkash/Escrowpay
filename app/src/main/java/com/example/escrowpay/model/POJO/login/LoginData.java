package com.example.escrowpay.model.POJO.login;

import com.example.escrowpay.model.POJO.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private User user;

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}
