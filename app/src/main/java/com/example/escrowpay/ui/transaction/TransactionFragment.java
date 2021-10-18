package com.example.escrowpay.ui.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowpay.R;
import com.example.escrowpay.adapter.TransactionAdapter;
import com.example.escrowpay.databinding.FragmentTransactionBinding;
import com.example.escrowpay.model.TransactionModel;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {

    private TransactionViewModel transactionViewModel;
    private FragmentTransactionBinding binding;
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        transactionViewModel =
                new ViewModelProvider(this).get(TransactionViewModel.class);

        binding = FragmentTransactionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.trans_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);

        transactionViewModel.getLiveTransModel().observe(getViewLifecycleOwner(), transactionUpdateOberver);

        return root;
    }
    private Observer<ArrayList<TransactionModel>> transactionUpdateOberver = new Observer<ArrayList<TransactionModel>>() {
        @Override
        public void onChanged(ArrayList<TransactionModel> transactionModelArrayList) {

            transactionAdapter = new TransactionAdapter(requireActivity(),transactionModelArrayList);
            recyclerView.setAdapter(transactionAdapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}