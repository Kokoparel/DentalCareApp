package com.example.dentalcareapp.app.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.models.Dentist;
import com.example.dentalcareapp.app.utils.DummyData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    private Spinner dentistSpinner;
    private EditText dateInput, timeInput, notesInput;
    private Button confirmButton;
    private TextView selectedDateText, selectedTimeText;

    private Calendar selectedCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Buat Appointment");

        initViews();
        setupDentistSpinner();
        setupClickListeners();
    }

    private void initViews() {
        dentistSpinner = findViewById(R.id.dentistSpinner);
        dateInput = findViewById(R.id.dateInput);
        timeInput = findViewById(R.id.timeInput);
        notesInput = findViewById(R.id.notesInput);
        confirmButton = findViewById(R.id.confirmButton);
        selectedDateText = findViewById(R.id.selectedDateText);
        selectedTimeText = findViewById(R.id.selectedTimeText);

        selectedCalendar = Calendar.getInstance();
    }

    private void setupDentistSpinner() {
        List<Dentist> dentists = DummyData.getDentists();
        List<String> dentistNames = new ArrayList<>();

        for (Dentist dentist : dentists) {
            dentistNames.add(dentist.getName() + " - " + dentist.getSpecialization());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                dentistNames
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dentistSpinner.setAdapter(adapter);
    }

    private void setupClickListeners() {
        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        timeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmBooking();
            }
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedCalendar.set(year, month, dayOfMonth);
                        String dateString = dayOfMonth + "/" + (month + 1) + "/" + year;
                        dateInput.setText(dateString);
                        selectedDateText.setText("Tanggal: " + dateString);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String timeString = String.format("%02d:%02d", hourOfDay, minute);
                        timeInput.setText(timeString);
                        selectedTimeText.setText("Waktu: " + timeString);
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );

        timePickerDialog.show();
    }

    private void confirmBooking() {
        String selectedDentist = dentistSpinner.getSelectedItem().toString();
        String date = dateInput.getText().toString();
        String time = timeInput.getText().toString();
        String notes = notesInput.getText().toString();

        if (date.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Mohon pilih tanggal dan waktu", Toast.LENGTH_SHORT).show();
            return;
        }

        // In a real app, this would save to database
        Toast.makeText(this,
                "Appointment berhasil dibuat!\nDokter: " + selectedDentist +
                        "\nTanggal: " + date +
                        "\nWaktu: " + time,
                Toast.LENGTH_LONG).show();

        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}