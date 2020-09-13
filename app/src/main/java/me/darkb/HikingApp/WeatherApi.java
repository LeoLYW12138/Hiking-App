package me.darkb.HikingApp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET
    Call<WeatherReport> getWeatherReport(@Query("id") Integer cityId, @Query("appid") String api_key);


}
