package com.example.dentalcareapp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.dentalcareapp.app.R;

public class DentistDetailActivity extends AppCompatActivity {

    private ImageView dentistPhoto;
    private TextView dentistName, specialization, education, experience, clinicName, availibilityText;
    private RatingBar ratingBar;
    private TextView ratingText;
    private Button bookButton, callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Dokter");

        initViews();
        loadDentistData();
        setupClickListeners();
    }

    private void initViews() {
        dentistPhoto = findViewById(R.id.dentistPhoto);
        dentistName = findViewById(R.id.dentistName);
        specialization = findViewById(R.id.specialization);
        education = findViewById(R.id.education);
        experience = findViewById(R.id.experience);
        clinicName = findViewById(R.id.clinicName);
        availibilityText = findViewById(R.id.availability);
        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);
        bookButton = findViewById(R.id.bookButton);
        callButton = findViewById(R.id.callButton);
    }

    private void loadDentistData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("dentist_name");
        String spec = intent.getStringExtra("dentist_specialization");
        float rating = intent.getFloatExtra("dentist_rating", 0f);
        String avail = intent.getStringExtra("dentist_availability");
        String clinic = intent.getStringExtra("dentist_clinic");
        String edu = intent.getStringExtra("dentist_education");
        String exp = intent.getStringExtra("dentist_experience");

        dentistName.setText(name);
        specialization.setText(spec);
        education.setText(edu);
        experience.setText(exp);
        clinicName.setText(clinic);
        availibilityText.setText(avail);
        ratingBar.setRating(rating);
        ratingText.setText(String.format("%.1f (120 reviews)", rating));

        // Set placeholder image
        dentistPhoto.setImageResource(R.mipmap.ic_launcher);
    }

    private void setupClickListeners() {
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DentistDetailActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(DentistDetailActivity.this,
                        "Menghubungi: 021-5551234",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}