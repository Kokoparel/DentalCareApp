package com.example.dentalcareapp.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.activities.BookingActivity;
import com.example.dentalcareapp.app.adapters.AppointmentAdapter;
import com.example.dentalcareapp.app.models.Appointment;
import com.example.dentalcareapp.app.utils.DummyData;
import java.util.List;

public class AppointmentFragment extends Fragment {

    private RecyclerView appointmentRecyclerView;
    private AppointmentAdapter adapter;
    private Button newAppointmentButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        appointmentRecyclerView = view.findViewById(R.id.appointmentRecyclerView);
        newAppointmentButton = view.findViewById(R.id.newAppointmentButton);

        setupRecyclerView();
        setupClickListeners();

        return view;
    }

    private void setupRecyclerView() {
        appointmentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Appointment> appointments = DummyData.getAppointments();
        adapter = new AppointmentAdapter(getContext(), appointments);
        appointmentRecyclerView.setAdapter(adapter);
    }

    private void setupClickListeners() {
        newAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookingActivity.class));
            }
        });
    }
}