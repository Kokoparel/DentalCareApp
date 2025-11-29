package com.example.dentalcareapp.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.models.Clinic;
import java.util.List;

public class ClinicAdapter extends RecyclerView.Adapter<ClinicAdapter.ClinicViewHolder> {

    private Context context;
    private List<Clinic> clinicList;

    public ClinicAdapter(Context context, List<Clinic> clinicList) {
        this.context = context;
        this.clinicList = clinicList;
    }

    @NonNull
    @Override
    public ClinicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_clinic, parent, false);
        return new ClinicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicViewHolder holder, int position) {
        Clinic clinic = clinicList.get(position);

        holder.nameText.setText(clinic.getName());
        holder.addressText.setText(clinic.getAddress());
        holder.phoneText.setText(clinic.getPhone());
        holder.distanceText.setText(clinic.getFormattedDistance());
        holder.ratingBar.setRating(clinic.getRating());
        holder.ratingText.setText(String.format("%.1f", clinic.getRating()));

        holder.directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format("geo:%f,%f?q=%f,%f(%s)",
                        clinic.getLatitude(), clinic.getLongitude(),
                        clinic.getLatitude(), clinic.getLongitude(),
                        clinic.getName());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            }
        });

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + clinic.getPhone()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }

    public static class ClinicViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nameText, addressText, phoneText, distanceText, ratingText;
        RatingBar ratingBar;
        Button directionsButton, callButton;

        public ClinicViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.clinicCard);
            nameText = itemView.findViewById(R.id.clinicName);
            addressText = itemView.findViewById(R.id.clinicAddress);
            phoneText = itemView.findViewById(R.id.clinicPhone);
            distanceText = itemView.findViewById(R.id.clinicDistance);
            ratingBar = itemView.findViewById(R.id.clinicRating);
            ratingText = itemView.findViewById(R.id.ratingText);
            directionsButton = itemView.findViewById(R.id.directionsButton);
            callButton = itemView.findViewById(R.id.callButton);
        }
    }
}
