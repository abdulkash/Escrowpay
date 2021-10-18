package com.example.escrowpay.model;

public class PendingEscrowModel {
    private String pendingEscrowDeal;
    private String pendingEscrowStatus;
    private int pendingEscrowAmount;

    public String getPendingEscrowDeal() {
        return pendingEscrowDeal;
    }

    public void setPendingEscrowDeal(String pendingEscrowDeal) {
        this.pendingEscrowDeal = pendingEscrowDeal;
    }

    public String getPendingEscrowStatus() {
        return pendingEscrowStatus;
    }

    public void setPendingEscrowStatus(String pendingEscrowStatus) {
        this.pendingEscrowStatus = pendingEscrowStatus;
    }

    public int getPendingEscrowAmount() {
        return pendingEscrowAmount;
    }

    public void setPendingEscrowAmount(int pendingEscrowAmount) {
        this.pendingEscrowAmount = pendingEscrowAmount;
    }

    public PendingEscrowModel(String pendingEscrowDeal, String pendingEscrowStatus, int pendingEscrowAmount) {
        this.pendingEscrowDeal = pendingEscrowDeal;
        this.pendingEscrowStatus = pendingEscrowStatus;
        this.pendingEscrowAmount = pendingEscrowAmount;
    }
}
