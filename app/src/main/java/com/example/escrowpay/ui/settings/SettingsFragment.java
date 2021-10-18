package com.example.escrowpay.ui.settings;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.escrowpay.LoginActivity;
import com.example.escrowpay.R;

public class SettingsFragment extends Fragment {

    private SettingsViewModel mViewModel;
    private Button voucher;
    private Button vitualCard;
    private Button vasPurchase;
    private Button changePassword;
    private Button twofactorAuthentication;
    private Button logOut;

//    public static SettingsFragment newInstance() {
//        return new SettingsFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        View root = inflater.inflate(R.layout.settings_fragment, container, false);

        voucher = root.findViewById(R.id.btn_voucher);
        vitualCard = root.findViewById(R.id.btn_vitual_crd);
        vasPurchase = root.findViewById(R.id.btn_vas_purchase);
        changePassword = root.findViewById(R.id.btn_change_pass);
        twofactorAuthentication = root.findViewById(R.id.btn_2fa_security);
        logOut = root.findViewById(R.id.btn_logout);

        voucher.setOnClickListener(view -> {
            Toast.makeText(getContext(),"Voucher Coming Soon!!",Toast.LENGTH_LONG).show();
        });
        vitualCard.setOnClickListener(view -> {
            Toast.makeText(getContext(),"Vitual Coming Soon!!",Toast.LENGTH_LONG).show();
        });
        vasPurchase.setOnClickListener(view -> {
            Toast.makeText(getContext(),"Voucher Coming Soon!!",Toast.LENGTH_LONG).show();
        });
        changePassword.setOnClickListener(view -> {
            Toast.makeText(getContext(),"Voucher Coming Soon!!",Toast.LENGTH_LONG).show();
        });
        twofactorAuthentication.setOnClickListener(view -> {
            Toast.makeText(getContext(),"Voucher Coming Soon!!",Toast.LENGTH_LONG).show();
        });
        logOut.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), LoginActivity.class));
        });

        return root;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
//        // TODO: Use the ViewModel
//    }

}