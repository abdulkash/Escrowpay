package com.example.escrowpay.ui.escrow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.escrowpay.model.MyEscrowModel;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class MyEscrowViewModel extends ViewModel {
    private MutableLiveData<ArrayList<MyEscrowModel>> mutableLiveData;
    private ArrayList<MyEscrowModel> myEscrowModelArrayList;

    public MyEscrowViewModel() {
        mutableLiveData = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        mutableLiveData.setValue(myEscrowModelArrayList);
    }

    private void populateList() {
        myEscrowModelArrayList = new ArrayList<>();
        myEscrowModelArrayList.add(new MyEscrowModel("Automobile Deal","Complete",200000));
        myEscrowModelArrayList.add(new MyEscrowModel("Phone Deal","Pending",500000));

    }
    public MutableLiveData<ArrayList<MyEscrowModel>> getLiveEscrowModel() {
        return mutableLiveData;
    }
}