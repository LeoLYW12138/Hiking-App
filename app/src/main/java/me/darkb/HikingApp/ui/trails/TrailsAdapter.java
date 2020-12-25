package me.darkb.HikingApp.ui.trails;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.List;

import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;

public class TrailsAdapter extends RecyclerView.Adapter<TrailsAdapter.TrailsViewHolder> {
    private List<Trail> trails = new ArrayList<>();

    public static class TrailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView trailImg;
        public TextView trailTitle;
        public TextView trailSubtitle;
        public SimpleRatingBar trailRating;

        public LinearLayout containerView;

        public TrailsViewHolder(View v) {
            super(v);

            containerView = v.findViewById(R.id.trail_item);
            trailImg = v.findViewById(R.id.trail_item_img);
            trailTitle = v.findViewById(R.id.trail_item_title);
            trailSubtitle = v.findViewById(R.id.trail_item_subtitle);
            trailRating = v.findViewById(R.id.trail_item_difficulty);

            containerView.setOnClickListener(view -> {
                Trail current = (Trail) containerView.getTag();
                Intent intent = new Intent(view.getContext(), TrailActivity.class);
                intent.putExtra("trail", current);

                view.getContext().startActivity(intent);
            });
        }

    }

    TrailsAdapter() {
        loadTrails();
    }

    private void loadTrails() {
        trails.add(new Trail(R.drawable.aberdeen_country_park, "Aberdeen natural trail - Hong Kong Island", "Hong Kong Trail", 1.0f, 3, 1.2f, 1.0f, "Hong Kong Island"));
        trails.add(new Trail(R.drawable.amah_rock, "Hung Mui Kuk Natural Trail - Central New Territories", "Wilson Trail", 1.0f, 3, 1.3f, 1.0f, "Central New Territories"));
        trails.add(new Trail(R.drawable.grassy_hill, "MacLehose Trail (Section 7) - Central New Territories", "MacLehose Trail", 3.0f, 2, 6.2f, 2.5f, "Central New Territories"));
        trails.add(new Trail(R.drawable.lai_chi_wo, "Lai Chi Wo Natural Trail - North New Territories", "Natural Trail", 1.0f, 5, 1.2f, 1.0f, "North New Territories"));
        Log.d("TrailAdapter", "loaded trails");
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trail, parent, false);

        return new TrailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailsViewHolder holder, int position) {
        Trail current;
        current = trails.get(position);
        holder.trailImg.setImageResource(current.getImg());
        holder.trailTitle.setText(current.getTitle());
        holder.trailSubtitle.setText(current.getSubtitle());
        holder.trailRating.setRating(current.getDifficulty());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return trails.size();
    }
}
