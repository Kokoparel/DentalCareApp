package com.example.dentalcareapp.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.activities.*;
import com.example.dentalcareapp.app.adapters.DentistAdapter;
import com.example.dentalcareapp.app.models.Dentist;
import com.example.dentalcareapp.app.utils.DummyData;
import com.example.dentalcareapp.app.utils.SharedPrefManager;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView welcomeText, tipText;
    private CardView bookingCard, gameCard, clinicCard, emergencyCard;
    private RecyclerView dentistRecyclerView;
    private DentistAdapter dentistAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);
        setupRecyclerView();
        loadUserData();
        loadDentalTip();
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        welcomeText = view.findViewById(R.id.welcomeText);
        tipText = view.findViewById(R.id.tipText);
        bookingCard = view.findViewById(R.id.bookingCard);
        gameCard = view.findViewById(R.id.gameCard);
        clinicCard = view.findViewById(R.id.clinicCard);
        emergencyCard = view.findViewById(R.id.emergencyCard);
        dentistRecyclerView = view.findViewById(R.id.dentistRecyclerView);
    }

    private void setupRecyclerView() {
        dentistRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<Dentist> dentists = DummyData.getDentists();
        dentistAdapter = new DentistAdapter(getContext(), dentists);
        dentistRecyclerView.setAdapter(dentistAdapter);
    }

    private void loadUserData() {
        SharedPrefManager prefManager = SharedPrefManager.getInstance(getContext());
        String userName = prefManager.getUserName();
        welcomeText.setText("Halo, " + userName + "!");
    }

    private void loadDentalTip() {
        List<String> tips = DummyData.getDentalTips();
        int randomIndex = (int) (Math.random() * tips.size());
        tipText.setText(tips.get(randomIndex));
    }

    private void setupClickListeners() {
        bookingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookingActivity.class));
            }
        });

        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GameActivity.class));
            }
        });

        clinicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapActivity.class));
            }
        });

        emergencyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Emergency contact functionality
                android.widget.Toast.makeText(getContext(),
                        "Hubungi: 119 (Emergency Dental)",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }
}
