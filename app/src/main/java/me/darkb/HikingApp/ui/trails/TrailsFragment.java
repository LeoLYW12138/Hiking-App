package me.darkb.HikingApp.ui.trails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import me.darkb.HikingApp.R;

public class TrailsFragment extends Fragment {
    private TrailsAdapter trailsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trails, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.trails_recycler_view);
        trailsAdapter = new TrailsAdapter();
        recyclerView.setAdapter(trailsAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        trailsAdapter.reload();
    }
}