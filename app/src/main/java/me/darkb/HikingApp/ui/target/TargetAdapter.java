package me.darkb.HikingApp.ui.target;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;
import java.util.List;

import me.darkb.HikingApp.MainActivity;
import me.darkb.HikingApp.R;
import me.darkb.HikingApp.data.Trail;
import me.darkb.HikingApp.ui.trails.TrailActivity;

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.TargetViewHolder> {

    public static class TargetViewHolder extends RecyclerView.ViewHolder {
        public TextView targetTitle;
        public SimpleRatingBar targetDifficulty;
        public ImageButton flag;

        public LinearLayout containerView;

        public TargetViewHolder(View v) {
            super(v);

            containerView = v.findViewById(R.id.target_item);
            targetTitle = v.findViewById(R.id.target_item_title);
            targetDifficulty = v.findViewById(R.id.target_item_difficulty);
            flag = v.findViewById(R.id.flag);

            containerView.setOnClickListener(view -> {
                Trail current = (Trail) containerView.getTag();
                Intent intent = new Intent(view.getContext(), TrailActivity.class);
//                intent.putExtra("trail", current);
                intent.putExtra("id", current.getId());

                view.getContext().startActivity(intent);
            });
        }
    }

    private List<Trail> targets = new ArrayList<>();

    TargetAdapter() {
        loadTargets();
    }

    private void loadTargets() {
//        targets.add(new Trail(R.drawable.amah_rock, "Hung Mui Kuk Natural Trail - Central New Territories", "Wilson Trail", 1.0f, 3, 1.3f, 1.0f, "Central New Territories"));
        targets = MainActivity.database.trailDao().getAllTargets();
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
        holder.targetDifficulty.setRating(current.getDifficulty());
        holder.flag.setImageResource((current.getTarget()) ? R.drawable.ic_round_flag_24 : R.drawable.ic_round_outlined_flag_24);
        holder.containerView.setTag(current);
        holder.flag.setOnClickListener(view -> {
            new AlertDialog.Builder(holder.containerView.getContext())
                    .setTitle("Delete target")
                    .setMessage("Do you really want to delete this target?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            MainActivity.database.trailDao().setTarget(!current.getTarget(), current.getId());
                            reload();
                            Toast.makeText(holder.containerView.getContext(), "Target deleted", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null).show();
        });

    }

    @Override
    public int getItemCount() {
        return targets.size();
    }

    public void reload() {
        targets = MainActivity.database.trailDao().getAllTargets();
        notifyDataSetChanged();
    }
}
