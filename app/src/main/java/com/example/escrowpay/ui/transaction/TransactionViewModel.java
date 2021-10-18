package com.example.escrowpay.ui.transaction;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class TransactionViewModel extends ViewModel {

    private MutableLiveData<ArrayList<TransactionModel>> liveTransModel;
    private ArrayList<TransactionModel> transactionModelArrayList;

    public TransactionViewModel() {
        liveTransModel = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        liveTransModel.setValue(transactionModelArrayList);
    }

    private void populateList() {
        transactionModelArrayList = new ArrayList<>();
        transactionModelArrayList.add(new TransactionModel("Abdul Kash","Recieved",553));
        transactionModelArrayList.add(new TransactionModel("Hansy kash","Sent",223));
    }

    public MutableLiveData<ArrayList<TransactionModel>> getLiveTransModel() {
        return liveTransModel;
    }
}