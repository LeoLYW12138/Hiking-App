package me.darkb.HikingApp.ui.trails;

import android.content.Context;
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

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.List;

import me.darkb.HikingApp.MainActivity;
import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;

public class TrailsAdapter extends RecyclerView.Adapter<TrailsAdapter.TrailsViewHolder> {
    private List<Trail> trails = new ArrayList<>();

    public static class TrailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView trailImg;
        public TextView trailTitle;
        public TextView trailSubtitle;
        public SimpleRatingBar trailDifficulty;
        public ChipGroup chipGroup;

        public LinearLayout containerView;

        public TrailsViewHolder(View v) {
            super(v);

            containerView = v.findViewById(R.id.trail_item);
            trailImg = v.findViewById(R.id.trail_item_img);
            trailTitle = v.findViewById(R.id.trail_item_title);
            trailSubtitle = v.findViewById(R.id.trail_item_subtitle);
            trailDifficulty = v.findViewById(R.id.trail_item_difficulty);
            chipGroup = v.findViewById(R.id.chip_group);

            containerView.setOnClickListener(view -> {
                Trail current = (Trail) containerView.getTag();
                Intent intent = new Intent(view.getContext(), TrailActivity.class);
                intent.putExtra("id", current.getId());
                view.getContext().startActivity(intent);
            });
        }

    }

    TrailsAdapter() {
        loadTrails();
    }

    private void loadTrails() {
        trails = MainActivity.database.trailDao().getAll();
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
        Context context = holder.trailImg.getContext();
        int resId = context.getResources().getIdentifier(current.getImg(), "drawable", context.getPackageName());
        holder.trailImg.setImageResource(resId);
        holder.trailTitle.setText(current.getTitle());
        holder.trailSubtitle.setText(current.getSubtitle());
        holder.trailDifficulty.setRating(current.getDifficulty());
        holder.containerView.setTag(current);
        String[] tags = current.getTags();
        Context context1 = holder.chipGroup.getContext();
        for (int i = 0; i < tags.length; i++) {
            Chip chip = new Chip(context1);
            chip.setText(tags[i]);
            chip.setChipBackgroundColorResource(context1.getResources().getIdentifier(String.format("colorTag%d", i + 1), "color", context1.getPackageName()));
            chip.setChecked(true);
            chip.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            chip.setTextSize(15);
            chip.setCheckedIconVisible(false);
            chip.setCloseIconVisible(false);
            holder.chipGroup.addView(chip);
        }
    }

    @Override
    public int getItemCount() {
        return trails.size();
    }

    public void reload() {
        trails = MainActivity.database.trailDao().getAll();
        notifyDataSetChanged();
    }
}
