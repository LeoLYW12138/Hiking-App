package me.darkb.HikingApp.ui.target;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import me.darkb.HikingApp.R;

public class TargetFragment extends Fragment {

    private TargetAdapter targetAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_target, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.target_recycler_view);
        targetAdapter = new TargetAdapter();
        recyclerView.setAdapter(targetAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        targetAdapter.reload();
    }
}