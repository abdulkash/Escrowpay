package com.example.escrowpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.escrowpay.R;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.Viewholder> {

    Context context;
    ArrayList<TransactionModel> transactionModelArrayList;

    public TransactionAdapter(Context context, ArrayList<TransactionModel> transactionModelArrayList) {
        this.context = context;
        this.transactionModelArrayList = transactionModelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        TransactionModel model = transactionModelArrayList.get(position);
        holder.trans_name.setText(model.getTrans_email());
        holder.trans_type.setText(model.getTrans_type());
        holder.trans_fund.setText(String.valueOf(model.getTrans_fund()));

    }

    @Override
    public int getItemCount() {
        return transactionModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView trans_user_img;
        private TextView trans_name,trans_type,trans_fund;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            trans_user_img = itemView.findViewById(R.id.trans_user_img);
            trans_name = itemView.findViewById(R.id.trans_name);
            trans_type = itemView.findViewById(R.id.trans_type);
            trans_fund = itemView.findViewById(R.id.trans_fund);


        }
    }
}
