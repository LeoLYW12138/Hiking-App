package me.darkb.HikingApp.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather")
    Call<WeatherReport> getWeatherReport(@Query("id") Integer cityId, @Query("appid") String apiKey);


}
