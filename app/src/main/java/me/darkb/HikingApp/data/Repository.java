package me.darkb.HikingApp.data;

import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private static final String TAG = "Repository";
    private WeatherReport weatherReport;
    private static final Integer cityId = 1819729;
    private static final String apiKey = "b759285a5434176ec109ef53db7a3833";
    private final Retrofit retrofit;

    public Repository() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        setupApi();
    }

    private void setupApi() {
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherReport> weatherReportCall = weatherApi.getWeatherReport(cityId, apiKey);
        weatherReportCall.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
                if (response.code() == 404) {
                    Log.e(TAG, response.message());

                }
                else if (!(response.isSuccessful())) {
                    Log.e(TAG, "Code: " + response.code());
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
