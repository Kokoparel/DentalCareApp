package com.example.dentalcareapp.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.models.Appointment;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    private Context context;
    private List<Appointment> appointmentList;

    public AppointmentAdapter(Context context, List<Appointment> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment = appointmentList.get(position);

        holder.dentistNameText.setText(appointment.getDentistName());
        holder.dateText.setText(appointment.getDate());
        holder.timeText.setText(appointment.getTime());
        holder.clinicText.setText(appointment.getClinicName());

        // Set status
        String status = appointment.getStatus();
        holder.statusText.setText(status.toUpperCase());

        if (status.equals("confirmed")) {
            holder.statusText.setTextColor(context.getResources().getColor(R.color.success_green));
        } else if (status.equals("pending")) {
            holder.statusText.setTextColor(context.getResources().getColor(R.color.warning_orange));
        } else if (status.equals("completed")) {
            holder.statusText.setTextColor(context.getResources().getColor(R.color.text_secondary));
        } else {
            holder.statusText.setTextColor(context.getResources().getColor(R.color.error_red));
        }

        holder.viewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Detail appointment: " + appointment.getId(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView dentistNameText, dateText, timeText, clinicText, statusText;
        Button viewDetailsButton;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.appointmentCard);
            dentistNameText = itemView.findViewById(R.id.dentistName);
            dateText = itemView.findViewById(R.id.appointmentDate);
            timeText = itemView.findViewById(R.id.appointmentTime);
            clinicText = itemView.findViewById(R.id.clinicName);
            statusText = itemView.findViewById(R.id.appointmentStatus);
            viewDetailsButton = itemView.findViewById(R.id.viewDetailsButton);
        }
    }
}
