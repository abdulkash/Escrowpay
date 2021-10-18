package com.example.escrowpay.ui.escrow;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.escrowpay.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MakeEscrow extends Fragment {

    private MakeEscrowViewModel mViewModel;
    private TextInputLayout selectOpponent;
    private AutoCompleteTextView list_opponent;
    private FloatingActionButton addContact;

    private ArrayList<String> arraylistOpponent;
    ArrayAdapter<String> arrayAdapterOpponent;

    public static MakeEscrow newInstance() {
        return new MakeEscrow();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MakeEscrowViewModel.class);

        View root = inflater.inflate(R.layout.make_escrow_fragment, container, false);
        selectOpponent = root.findViewById(R.id.select_opponent);
        list_opponent = root.findViewById(R.id.list_opponent);
        addContact = root.findViewById(R.id.add_contact);

        addContact.setOnClickListener(view -> {
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());

            LayoutInflater inflater1 =LayoutInflater.from(getContext());
            View register_phone_layout=inflater1.inflate(R.layout.add_contact_layout, null);
            final TextInputLayout opponent_email = register_phone_layout.findViewById(R.id.txt_add_contact_email);
            final Button invite_opponent = register_phone_layout.findViewById(R.id.btn_invite_opponent);

            alertDialog.setView(register_phone_layout);
            AlertDialog dialog = alertDialog.create();
            dialog.show();

            invite_opponent.setOnClickListener(view1 -> {
                String opponent_mail = opponent_email.getEditText().getText().toString();
                Toast.makeText(getContext(),"Sent Invite to " + opponent_mail,Toast.LENGTH_LONG).show();
                dialog.dismiss();
            });
        });

        arraylistOpponent = new ArrayList<>();
        arraylistOpponent.add("abdulkash");
        arraylistOpponent.add("hansykash");
        arraylistOpponent.add("smilebuddy");

        arrayAdapterOpponent = new ArrayAdapter<>(getContext(),R.layout.dropdown_menu_item,arraylistOpponent);
        list_opponent.setAdapter(arrayAdapterOpponent);
        list_opponent.setThreshold(1);



        return root;

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(MakeEscrowViewModel.class);
//        // TODO: Use the ViewModel
//    }

}