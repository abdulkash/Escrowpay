package com.example.escrowpay.model;

public class MyEscrowModel {
    private String escrowDeal;
    private String escrowStatus;
    private int escrowAmount;

    public MyEscrowModel(String escrowDeal, String escrowStatus, int escrowAmount) {
        this.escrowDeal = escrowDeal;
        this.escrowStatus = escrowStatus;
        this.escrowAmount = escrowAmount;
    }

    public String getEscrowDeal() {
        return escrowDeal;
    }

    public void setEscrowDeal(String escrowDeal) {
        this.escrowDeal = escrowDeal;
    }

    public String getEscrowStatus() {
        return escrowStatus;
    }

    public void setEscrowStatus(String escrowStatus) {
        this.escrowStatus = escrowStatus;
    }

    public int getEscrowAmount() {
        return escrowAmount;
    }

    public void setEscrowAmount(int escrowAmount) {
        this.escrowAmount = escrowAmount;
    }
}
