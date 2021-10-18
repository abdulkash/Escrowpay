package com.example.escrowpay.model;

public class TransactionModel {
    private String trans_email;
    private String trans_type;
    private int trans_fund;


    public TransactionModel(String trans_email, String trans_type, int trans_bal) {
        this.trans_email = trans_email;
        this.trans_type = trans_type;
        this.trans_fund = trans_bal;

    }

    public String getTrans_email() {
        return trans_email;
    }

    public void setTrans_email(String trans_email) {
        this.trans_email = trans_email;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public int getTrans_fund() {
        return trans_fund;
    }

    public void setTrans_fund(int trans_fund) {
        this.trans_fund = trans_fund;
    }

}
