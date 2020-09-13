package me.darkb.HikingApp;


public class WeatherReport {
    @Expose
    @SerializedName("main")
    private MainWeather mMain;
    @SerializedName("dt")
    private int mTime;

    public WeatherReport(MainWeather main, int time) {
        mMain = main;
        mTime = time;
    }
}
