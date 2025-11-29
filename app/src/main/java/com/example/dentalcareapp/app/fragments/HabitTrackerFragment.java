package com.example.dentalcareapp.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.utils.SharedPrefManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HabitTrackerFragment extends Fragment {

    private TextView streakCountText, dateText, pointsText;
    private CardView morningCard, nightCard, flossCard;
    private Button morningButton, nightButton, flossButton;
    private TextView morningStatus, nightStatus, flossStatus;

    private boolean morningDone = false;
    private boolean nightDone = false;
    private boolean flossDone = false;
    private int currentStreak = 0;
    private int todayPoints = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habit_tracker, container, false);

        initViews(view);
        loadHabitData();
        setupClickListeners();
        updateUI();

        return view;
    }

    private void initViews(View view) {
        streakCountText = view.findViewById(R.id.streakCountText);
        dateText = view.findViewById(R.id.dateText);
        pointsText = view.findViewById(R.id.pointsText);

        morningCard = view.findViewById(R.id.morningCard);
        nightCard = view.findViewById(R.id.nightCard);
        flossCard = view.findViewById(R.id.flossCard);

        morningButton = view.findViewById(R.id.morningButton);
        nightButton = view.findViewById(R.id.nightButton);
        flossButton = view.findViewById(R.id.flossButton);

        morningStatus = view.findViewById(R.id.morningStatus);
        nightStatus = view.findViewById(R.id.nightStatus);
        flossStatus = view.findViewById(R.id.flossStatus);

        // Set current date
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("id", "ID"));
        dateText.setText(sdf.format(new Date()));
    }

    private void loadHabitData() {
        SharedPrefManager prefManager = SharedPrefManager.getInstance(getContext());
        currentStreak = prefManager.getStreakCount();

        // Load today's habits from SharedPreferences
        String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        morningDone = prefManager.getBoolean("morning_" + today, false);
        nightDone = prefManager.getBoolean("night_" + today, false);
        flossDone = prefManager.getBoolean("floss_" + today, false);

        calculatePoints();
    }

    private void calculatePoints() {
        todayPoints = 0;
        if (morningDone) todayPoints += 10;
        if (nightDone) todayPoints += 10;
        if (flossDone) todayPoints += 5;
    }

    private void setupClickListeners() {
        morningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHabit("morning");
            }
        });

        nightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHabit("night");
            }
        });

        flossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHabit("floss");
            }
        });
    }

    private void toggleHabit(String habitType) {
        String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        SharedPrefManager prefManager = SharedPrefManager.getInstance(getContext());

        switch (habitType) {
            case "morning":
                morningDone = !morningDone;
                prefManager.saveBoolean("morning_" + today, morningDone);
                if (morningDone) {
                    Toast.makeText(getContext(), "Bagus! +10 poin", Toast.LENGTH_SHORT).show();
                }
                break;

            case "night":
                nightDone = !nightDone;
                prefManager.saveBoolean("night_" + today, nightDone);
                if (nightDone) {
                    Toast.makeText(getContext(), "Sempurna! +10 poin", Toast.LENGTH_SHORT).show();
                    checkStreakUpdate();
                }
                break;

            case "floss":
                flossDone = !flossDone;
                prefManager.saveBoolean("floss_" + today, flossDone);
                if (flossDone) {
                    Toast.makeText(getContext(), "Luar biasa! +5 poin", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        calculatePoints();
        updateUI();
    }

    private void checkStreakUpdate() {
        if (morningDone && nightDone) {
            currentStreak++;
            SharedPrefManager prefManager = SharedPrefManager.getInstance(getContext());
            prefManager.setStreakCount(currentStreak);

            Toast.makeText(getContext(),
                    "🔥 Streak: " + currentStreak + " hari!",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void updateUI() {
        streakCountText.setText(currentStreak + " Hari");
        pointsText.setText(todayPoints + " Poin");

        // Update morning card
        if (morningDone) {
            morningButton.setText("✓ Selesai");
            morningButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.success_green));
            morningStatus.setText("Sudah sikat gigi pagi");
        } else {
            morningButton.setText("Tandai");
            morningButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.colorPrimary));
            morningStatus.setText("Belum sikat gigi pagi");
        }

        // Update night card
        if (nightDone) {
            nightButton.setText("✓ Selesai");
            nightButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.success_green));
            nightStatus.setText("Sudah sikat gigi malam");
        } else {
            nightButton.setText("Tandai");
            nightButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.colorPrimary));
            nightStatus.setText("Belum sikat gigi malam");
        }

        // Update floss card
        if (flossDone) {
            flossButton.setText("✓ Selesai");
            flossButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.success_green));
            flossStatus.setText("Sudah flossing");
        } else {
            flossButton.setText("Tandai");
            flossButton.setBackgroundTintList(
                    getResources().getColorStateList(R.color.colorPrimary));
            flossStatus.setText("Belum flossing");
        }
    }
}