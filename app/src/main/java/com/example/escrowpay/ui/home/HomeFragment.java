package com.example.escrowpay.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escrowpay.AddFund;
import com.example.escrowpay.R;
import com.example.escrowpay.adapter.CardAdapter;
import com.example.escrowpay.adapter.PendingEscrow;
import com.example.escrowpay.adapter.TransactionAdapter;
import com.example.escrowpay.databinding.FragmentHomeBinding;
import com.example.escrowpay.model.CardModel;
import com.example.escrowpay.model.PendingEscrowModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    RecyclerView recyclerView,recyclerViewCard;
    CardAdapter cardAdapter;
    PendingEscrow pendingEscrow;
    ImageButton addFund;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.home_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);

        recyclerViewCard = root.findViewById(R.id.recyclerview_card);
        recyclerViewCard.setLayoutManager(new LinearLayoutManager(recyclerViewCard.getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerViewCard.setHasFixedSize(true);



        addFund = root.findViewById(R.id.add_fund);
        addFund.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), AddFund.class));
        });

        homeViewModel.getLivePendingEscrowModel().observe(getViewLifecycleOwner(),myPendingEscrowUpdateObserver);
        homeViewModel.getCardLivedata().observe(getViewLifecycleOwner(),cardmodelObserver);

        return root;
    }
    private Observer<ArrayList<PendingEscrowModel>> myPendingEscrowUpdateObserver = new Observer<ArrayList<PendingEscrowModel>>() {
        @Override
        public void onChanged(ArrayList<PendingEscrowModel> myEscrowModelArrayList) {

            pendingEscrow = new PendingEscrow(requireActivity(),myEscrowModelArrayList);
            recyclerView.setAdapter(pendingEscrow);
        }
    };
    private Observer<ArrayList<CardModel>> cardmodelObserver = new Observer<ArrayList<CardModel>>() {
        @Override
        public void onChanged(ArrayList<CardModel> cardModels) {
            cardAdapter = new CardAdapter(requireContext(),cardModels);
            recyclerViewCard.setAdapter(cardAdapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}