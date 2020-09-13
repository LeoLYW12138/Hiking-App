package me.darkb.HikingApp;

import com.google.gson.annotations.SerializedName;

public class MainWeather {

    @SerializedName("temp_max")
    private float mTemp_max;
    @SerializedName("temp_min")
    private float mTemp_min;
    @SerializedName("humidity")
    private int mHumidity;

    public MainWeather(float temp_max, float temp_min, int humidity) {
        mTemp_max = temp_max;
        mTemp_min = temp_min;
        mHumidity = humidity;
    }
}
