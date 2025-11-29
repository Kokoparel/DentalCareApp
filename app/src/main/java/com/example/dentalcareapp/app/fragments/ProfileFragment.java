package com.example.dentalcareapp.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.activities.LoginActivity;
import com.example.dentalcareapp.app.utils.SharedPrefManager;

public class ProfileFragment extends Fragment {

    private TextView nameText, emailText, streakText;
    private CardView editProfileCard, settingsCard, aboutCard;
    private Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        initViews(view);
        loadUserData();
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        nameText = view.findViewById(R.id.profileName);
        emailText = view.findViewById(R.id.profileEmail);
        streakText = view.findViewById(R.id.profileStreak);
        editProfileCard = view.findViewById(R.id.editProfileCard);
        settingsCard = view.findViewById(R.id.settingsCard);
        aboutCard = view.findViewById(R.id.aboutCard);
        logoutButton = view.findViewById(R.id.logoutButton);
    }

    private void loadUserData() {
        SharedPrefManager prefManager = SharedPrefManager.getInstance(getContext());
        nameText.setText(prefManager.getUserName());
        emailText.setText(prefManager.getUserEmail());
        streakText.setText(prefManager.getStreakCount() + " Hari Streak 🔥");
    }

    private void setupClickListeners() {
        editProfileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(getContext(),
                        "Edit profil akan segera hadir",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(getContext(),
                        "Pengaturan akan segera hadir",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(getContext(),
                        "DentalCare v1.0.0",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getContext()).logout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}