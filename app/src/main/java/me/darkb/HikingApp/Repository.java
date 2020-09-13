package me.darkb.HikingApp;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private WeatherReport weatherReport;

    public Repository() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("api.openweathermap.org/data/2.5/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherReport> call = weatherApi.getWeatherReport();
        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
                if (!response.isSuccessful()) {
                    Log.e("Repository", "Code: " + response.code());
                    return;
                }

                weatherReport = response.body();

            }

            @Override
            public void onFailure(Call<WeatherReport> call, Throwable t) {
                Log.e("Repository", t.getMessage());
            }
        });
    }

    public WeatherReport getWeatherReport() {
        return weatherReport;
    }
}
