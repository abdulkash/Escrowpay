package com.example.escrowpay.design;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.escrowpay.R;

public class CustomDiag {
   private Activity activity;
   private AlertDialog alertDialog;

    public CustomDiag(Activity activity) {
        this.activity = activity;
    }

   public void loadingDialogue()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.custom_dialogue,null));
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }
    public void dismiss(){
        alertDialog.dismiss();;
    }
}
