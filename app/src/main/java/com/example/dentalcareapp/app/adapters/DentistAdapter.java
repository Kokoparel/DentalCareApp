package com.example.dentalcareapp.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.activities.DentistDetailActivity;
import com.example.dentalcareapp.app.models.Dentist;
import java.util.List;

public class DentistAdapter extends RecyclerView.Adapter<DentistAdapter.DentistViewHolder> {

    private Context context;
    private List<Dentist> dentistList;

    public DentistAdapter(Context context, List<Dentist> dentistList) {
        this.context = context;
        this.dentistList = dentistList;
    }

    @NonNull
    @Override
    public DentistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dentist, parent, false);
        return new DentistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DentistViewHolder holder, int position) {
        Dentist dentist = dentistList.get(position);

        holder.nameText.setText(dentist.getName());
        holder.specializationText.setText(dentist.getSpecialization());
        holder.ratingBar.setRating(dentist.getRating());
        holder.ratingText.setText(String.format("%.1f", dentist.getRating()));

        // Set placeholder image
        holder.photoImage.setImageResource(R.mipmap.ic_launcher);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DentistDetailActivity.class);
                intent.putExtra("dentist_id", dentist.getId());
                intent.putExtra("dentist_name", dentist.getName());
                intent.putExtra("dentist_specialization", dentist.getSpecialization());
                intent.putExtra("dentist_rating", dentist.getRating());
                intent.putExtra("dentist_availability", dentist.getAvailability());
                intent.putExtra("dentist_clinic", dentist.getClinicName());
                intent.putExtra("dentist_education", dentist.getEducation());
                intent.putExtra("dentist_experience", dentist.getExperience());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dentistList.size();
    }

    public static class DentistViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView photoImage;
        TextView nameText, specializationText, ratingText;
        RatingBar ratingBar;

        public DentistViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.dentistCard);
            photoImage = itemView.findViewById(R.id.dentistPhoto);
            nameText = itemView.findViewById(R.id.dentistName);
            specializationText = itemView.findViewById(R.id.dentistSpecialization);
            ratingBar = itemView.findViewById(R.id.dentistRating);
            ratingText = itemView.findViewById(R.id.ratingText);
        }
    }
}