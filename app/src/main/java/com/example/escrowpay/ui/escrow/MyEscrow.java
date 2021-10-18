package com.example.escrowpay.ui.escrow;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.escrowpay.R;
import com.example.escrowpay.adapter.MyEscrowAdapter;
import com.example.escrowpay.adapter.TransactionAdapter;
import com.example.escrowpay.model.MyEscrowModel;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class MyEscrow extends Fragment {

    private MyEscrowViewModel mViewModel;
    RecyclerView recyclerView;
    MyEscrowAdapter myEscrowAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MyEscrowViewModel.class);
        View root = inflater.inflate(R.layout.my_escrow_fragment, container, false);

        recyclerView = root.findViewById(R.id.myescrow_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);

        mViewModel.getLiveEscrowModel().observe(getViewLifecycleOwner(),myEscrowUpdateObserver);

        return root;
    }
    private Observer<ArrayList<MyEscrowModel>> myEscrowUpdateObserver = new Observer<ArrayList<MyEscrowModel>>() {
        @Override
        public void onChanged(ArrayList<MyEscrowModel> myEscrowModelArrayList) {

            myEscrowAdapter = new MyEscrowAdapter(requireActivity(),myEscrowModelArrayList);
            recyclerView.setAdapter(myEscrowAdapter);
        }
    };

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        // TODO: Use the ViewModel
//    }

}