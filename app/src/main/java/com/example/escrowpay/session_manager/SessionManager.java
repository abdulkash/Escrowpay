package com.example.escrowpay.session_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.escrowpay.MainActivity;
import com.example.escrowpay.StartScreenActivity;
import com.example.escrowpay.model.POJO.User;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Escrowpaypref";

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_USERNAME = "username";

    public static final String KEY_EMAIL = "email";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String Username, String Email) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
// Storing name in pref
        editor.putString(KEY_USERNAME, Username);
// Storing email in pref
        editor.putString(KEY_EMAIL, Email);
// commit changes
        editor.commit();
    }

    public void checkLogin() {
// Check login status
        if (!this.isLoggedIn()) {
// user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, StartScreenActivity.class);
// Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
// Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
// Staring Login Activity
            context.startActivity(i);
        }else {
            Intent i = new Intent(context, MainActivity.class);
// Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
// Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
// Staring Login Activity
            context.startActivity(i);
        }

    }
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, StartScreenActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }
}
