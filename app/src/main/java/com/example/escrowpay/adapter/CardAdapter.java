package com.example.escrowpay.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowpay.R;
import com.example.escrowpay.model.CardModel;
import com.example.escrowpay.model.MyEscrowModel;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    Context context;
    ArrayList<CardModel> cardModelArrayList;

    public CardAdapter(Context context, ArrayList<CardModel> cardModelArrayList) {
        this.context = context;
        this.cardModelArrayList = cardModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardModel model = cardModelArrayList.get(position);
        holder.layout.setBackgroundColor(model.getBackgroundColor());
        holder.cardAmount.setText(String.valueOf(model.getCardAmount()));
        holder.cardNumber.setText(model.getCardNumber());
        holder.cardExpiryDate.setText(model.getExpiryDate());
        holder.cardCvv.setText(model.getCvv());

    }

    @Override
    public int getItemCount() {
        return cardModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            RelativeLayout layout;
            TextView cardAmount, cardNumber,cardExpiryDate,cardCvv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_card);
            cardAmount = itemView.findViewById(R.id.txt_card_bal_amount);
            cardNumber = itemView.findViewById(R.id.txt_card_num);
            cardExpiryDate = itemView.findViewById(R.id.card_expirydate);
            cardCvv = itemView.findViewById(R.id.card_cvv);

        }
    }
}
