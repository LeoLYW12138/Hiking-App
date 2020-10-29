package me.darkb.HikingApp.ui.trails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrailsAdapter extends RecyclerView.Adapter<TrailsAdapter.TrailsViewHolder> {
    public static class TrailsViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TrailsViewHolder(View v) {
            super(v);
            view = v;
        }
    }
    public TrailsAdapter(){

    }

    @NonNull
    @Override
    public TrailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.
    }
}
