package me.darkb.HikingApp.ui.trails;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;

public class TrailsAdapter extends RecyclerView.Adapter<TrailsAdapter.TrailsViewHolder> {
    public static class TrailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView trailImg;
        public TextView trailTitle;
        public TextView trailSubtitle;
        public TextView trailDifficulty;
        public RatingBar trailRating;

        public ConstraintLayout containerView;

        public TrailsViewHolder(View v) {
            super(v);

            containerView = v.findViewById(R.id.item_trail);
            trailImg = v.findViewById(R.id.trail_item_img);
            trailTitle = v.findViewById(R.id.trail_item_title);
            trailSubtitle = v.findViewById(R.id.trail_item_subtitle);
            trailDifficulty = v.findViewById(R.id.trail_item_difficulty);
            trailRating = v.findViewById(R.id.trail_item_rating);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Trail current = (Trail) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), TrailActivity.class);
                    intent.putExtra("id", current.getId());

                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Trail> trails = new ArrayList<>();

    TrailsAdapter(){
        loadTrails();
    }

    private void loadTrails() {
        trails.add(new Trail());
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
        holder.trailImg.setImageDrawable(current.getImg());
        holder.trailTitle.setText(current.getTitle());
        holder.trailSubtitle.setText(current.getSubtitle());
        holder.trailDifficulty.setText(String.valueOf(current.getDifficulty()));
        holder.trailRating.setRating(current.getRating());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return trails.size();
    }
}
