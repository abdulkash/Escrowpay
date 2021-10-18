package com.example.escrowpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowpay.R;
import com.example.escrowpay.model.MyEscrowModel;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class MyEscrowAdapter extends RecyclerView.Adapter<MyEscrowAdapter.Viewholder> {
    Context context;
    ArrayList<MyEscrowModel> myEscrowModelArrayList;

    public MyEscrowAdapter(Context context, ArrayList<MyEscrowModel> myEscrowModelArrayList) {
        this.context = context;
        this.myEscrowModelArrayList = myEscrowModelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myescrow_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        MyEscrowModel model = myEscrowModelArrayList.get(position);
        holder.escrow_deal.setText(model.getEscrowDeal());
        holder.escrow_status.setText(model.getEscrowStatus());
        holder.escrow_amount.setText(String.valueOf(model.getEscrowAmount()));
    }

    @Override
    public int getItemCount() {
        return myEscrowModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView escrow_deal,escrow_status,escrow_amount;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            escrow_deal = itemView.findViewById(R.id.escrow_deal);
            escrow_status = itemView.findViewById(R.id.escrow_status);
            escrow_amount = itemView.findViewById(R.id.escrow_amount);
        }
    }
}
