package com.example.escrowpay.ui.home;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.escrowpay.model.CardModel;
import com.example.escrowpay.model.PendingEscrowModel;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<PendingEscrowModel>> mutableLiveData;
    private MutableLiveData<ArrayList<CardModel>> cardLivedata;
    private ArrayList<PendingEscrowModel> pendingEscrowModelArrayList;
    private ArrayList<CardModel> cardModelArrayList;

    public HomeViewModel() {
        mutableLiveData = new MutableLiveData<>();
        cardLivedata = new MutableLiveData<>();
        init();
    }

    private void init() {
        populateList();
        mutableLiveData.setValue(pendingEscrowModelArrayList);
        populateList1();
        cardLivedata.setValue(cardModelArrayList);
    }

    private void populateList1() {
        cardModelArrayList = new ArrayList<>();
        cardModelArrayList.add(new CardModel(Color.parseColor("#2196f3"),55555,"XXXX  XXXX  XXXX  1234 ","12/25","123"));
        cardModelArrayList.add(new CardModel(Color.DKGRAY,22222,"XXXX  XXXX  XXXX  1246 ","12/25","246"));
        cardModelArrayList.add(new CardModel(Color.parseColor("#FFBB86FC"),33333,"XXXX  XXXX  XXXX  1243 ","12/25","321"));
        cardModelArrayList.add(new CardModel(Color.parseColor("#FF3700B3"),33333,"XXXX  XXXX  XXXX  1243 ","12/25","321"));

    }

    private void populateList() {
        pendingEscrowModelArrayList = new ArrayList<>();
        pendingEscrowModelArrayList.add(new PendingEscrowModel("Abdul Kash","Pending",553));
        pendingEscrowModelArrayList.add(new PendingEscrowModel("Hansy kash","Pending",223));
    }
    public MutableLiveData<ArrayList<PendingEscrowModel>> getLivePendingEscrowModel() {
        return mutableLiveData;
    }
    public MutableLiveData<ArrayList<CardModel>> getCardLivedata(){
        return cardLivedata;
    }
}