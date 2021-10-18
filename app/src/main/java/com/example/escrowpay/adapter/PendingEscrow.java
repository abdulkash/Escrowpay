package com.example.escrowpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowpay.R;
import com.example.escrowpay.model.PendingEscrowModel;

import java.util.ArrayList;

public class PendingEscrow extends RecyclerView.Adapter<PendingEscrow.ViewHolder>{

    Context context;
    ArrayList<PendingEscrowModel> myPendingEscrowModelArrayList;

    public PendingEscrow(Context context, ArrayList<PendingEscrowModel> myPendingEscrowModelArrayList) {
        this.context = context;
        this.myPendingEscrowModelArrayList = myPendingEscrowModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pendingescrow_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PendingEscrowModel model = myPendingEscrowModelArrayList.get(position);
        holder.pending_escrow_deal.setText(model.getPendingEscrowDeal());
        holder.pending_escrow_status.setText(model.getPendingEscrowStatus());
        holder.pending_escrow_amount.setText(String.valueOf(model.getPendingEscrowAmount()));
    }

    @Override
    public int getItemCount() {
        return myPendingEscrowModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView pending_escrow_deal,pending_escrow_status,pending_escrow_amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pending_escrow_deal = itemView.findViewById(R.id.pending_escrow_deal);
            pending_escrow_status = itemView.findViewById(R.id.pending_escrow_status);
            pending_escrow_amount = itemView.findViewById(R.id.pending_escrow_amount);
        }
    }
}
