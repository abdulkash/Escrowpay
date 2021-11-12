package com.example.escrowpay.model.POJO.login;

import com.example.escrowpay.model.POJO.register.Errors;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private LoginData data;
    @SerializedName("errors")
    @Expose
    private Object errors;

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public LoginData getData() {
        return data;
    }

    public Object getErrors() {
        return errors;
    }
}
