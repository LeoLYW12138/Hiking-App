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
        View root = inflater.inflate(R.layout.fragment_weather, container, false);

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
        final TextView warningInfo = root.findViewById(R.id.warning_info);
        weatherViewModel.getWarningInfo().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                warningInfo.setText(s);
            }
        });
        final TextView sunrise = root.findViewById(R.id.sunrise);
        weatherViewModel.getSunrise().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                sunrise.setText(s);
            }
        });
        final TextView sunset = root.findViewById(R.id.sunset);
        weatherViewModel.getSunset().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                sunset.setText(s);
            }
        });
        final TextView moonrise = root.findViewById(R.id.moonrise);
        weatherViewModel.getMoonrise().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                moonrise.setText(s);
            }
        });
        final TextView moonset = root.findViewById(R.id.moonset);
        weatherViewModel.getMoonset().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                moonset.setText(s);
            }
        });
        final TextView moonPhrase = root.findViewById(R.id.moon_phrase);
        weatherViewModel.getMoonPhrase().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                moonPhrase.setText(s);
            }
        });
        return root;
    }
}