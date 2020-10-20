package me.darkb.HikingApp.data;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class WeatherReport {
    @SerializedName("main")
    private MainWeather main;
    @SerializedName("dt")
    private int time;

    public MainWeather getMain() {
        return main;
    }

    public int getTime() {
        return time;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
