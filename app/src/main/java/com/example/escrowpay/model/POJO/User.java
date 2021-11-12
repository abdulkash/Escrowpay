package com.example.escrowpay.model.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;

}
