package me.darkb.HikingApp.ui.trails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import me.darkb.HikingApp.R;

public class TrailsFragment extends Fragment {

    private TrailsViewModel trailsViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trailsViewModel =
                new ViewModelProvider(this).get(TrailsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_trails, container, false);
//        final TextView textView = root.findViewById(R.id.text_trails);
//        trailsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        recyclerView = view.findViewById(R.id.trails_recycler_view);
        return view;
    }
}