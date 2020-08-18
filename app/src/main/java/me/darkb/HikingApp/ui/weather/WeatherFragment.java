package me.darkb.HikingApp.ui.weather;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import me.darkb.HikingApp.R;

public class WeatherFragment extends Fragment {

    private WeatherViewModel weatherViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Context context = getContext();
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        View root = inflater.inflate(R.layout.fragment_temp, container, false);

        final TextView temp = root.findViewById(R.id.temp);
        weatherViewModel.getTemp().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                temp.setText(s);
            }
        });
        final TextView humid = root.findViewById(R.id.humid);
        weatherViewModel.getHumid().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                humid.setText(s);
            }
        });
        final TextView UV = root.findViewById(R.id.UV);
        weatherViewModel.getUV().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                UV.setText(s);
            }
        });
        final TextView rain = root.findViewById(R.id.rain);
        weatherViewModel.getRain().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                rain.setText(s);
            }
        });
        final TextView last_update = root.findViewById(R.id.last_update);
        weatherViewModel.getUpdateTime().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                last_update.setText(s);
            }
        });
        return root;
    }
}