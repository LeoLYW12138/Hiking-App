package me.darkb.HikingApp.ui.target;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.List;

import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;
import me.darkb.HikingApp.ui.trails.TrailActivity;

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.TargetViewHolder> {
    private List<Trail> targets = new ArrayList<>();

    public static class TargetViewHolder extends RecyclerView.ViewHolder {
        public TextView targetTitle;
        public RatingBar targetRating;
        public SimpleRatingBar simpleRatingBar;

        public LinearLayout containerView;

        public TargetViewHolder(View v){
            super(v);

            containerView = v.findViewById(R.id.target_item);
            targetTitle = v.findViewById(R.id.target_item_title);
//            targetRating = v.findViewById(R.id.target_item_difficulty);
            simpleRatingBar = v.findViewById(R.id.simple_rating_bar);

            containerView.setOnClickListener(view -> {
                Trail current = (Trail) containerView.getTag();
                Intent intent = new Intent(view.getContext(), TrailActivity.class);
                intent.putExtra("trail", current);

                view.getContext().startActivity(intent);
            });

        }
    }

    TargetAdapter() {
        loadTargets();
    }

    private void loadTargets(){
        targets.add(new Trail(R.drawable.amah_rock, "Hung Mui Kuk Natural Trail - Central New Territories", "Wilson Trail", 1.0f, 3, 1.3f, 1.0f, "Central New Territories"));
        Log.d("TargetAdapter", "loaded target");
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TargetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_target, parent, false);
        return new TargetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TargetViewHolder holder, int position) {
        Trail current;
        current = targets.get(position);
        holder.targetTitle.setText(current.getTitle());
//        holder.targetRating.setRating(current.getDifficulty());
        holder.simpleRatingBar.setRating(current.getDifficulty());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return targets.size();
    }
}
