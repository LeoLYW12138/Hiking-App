package me.darkb.HikingApp.ui.weather;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Date;

import me.darkb.HikingApp.data.Repository;
import me.darkb.HikingApp.data.WeatherReport;

public class WeatherViewModel extends AndroidViewModel {

    private static final String TAG = "WeatherViewModel";
    private MutableLiveData<String> temp;
    private MutableLiveData<String> humid;
    private MutableLiveData<String> uv;
    private MutableLiveData<String> rain;
    private MutableLiveData<String> updateTime;
    private RequestQueue requestQueue;
    private Repository repository;

    public WeatherViewModel(Application application) {
        super(application);
        Context context = getApplication().getApplicationContext();
        requestQueue = Volley.newRequestQueue(context);
        temp = new MutableLiveData<>();
        humid = new MutableLiveData<>();
        uv = new MutableLiveData<>();
        rain = new MutableLiveData<>();
        updateTime = new MutableLiveData<>();
//        loadWeather();
        this.repository = new Repository();
        loadWeatherApi();
    }

    public void loadWeatherApi() {
        WeatherReport weatherReport = repository.getWeatherReport();
        Log.d(TAG, weatherReport.toString());
        temp.setValue(String.format("%d°C", weatherReport.getMain().getFeelsLike()));
        humid.setValue(String.format("%d%%", weatherReport.getMain().getHumidity()));
        updateTime.setValue(new Date(weatherReport.getTime() * 1000).toString());
        uv.setValue("10 (High)");
        rain.setValue("0mm");
    }


    private void loadWeather() {
        Log.i("Weather", "Performed loadWeather once");
        String WEATHERURL = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=rhrread&lang=en";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, WEATHERURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject temperature = response.getJSONObject("temperature").getJSONArray("data").getJSONObject(1);
                    temp.setValue(String.format("%d°C", temperature.getInt("value")));
                    JSONObject humidity = response.getJSONObject("humidity").getJSONArray("data").getJSONObject(0);
                    humid.setValue(String.format("%d%%", humidity.getInt("value")));
                    JSONObject uvIndex = response.optJSONObject("uvindex");
                    uv.setValue((uvIndex != null) ? parseUV(uvIndex) : "0 (Low)");
                    JSONObject rainfall = response.getJSONObject("rainfall").getJSONArray("data").getJSONObject(0);
                    rain.setValue(String.format("%dmm", rainfall.getInt("max")));
                    String time = response.getString("updateTime");
                    OffsetDateTime offsetTime = OffsetDateTime.parse(time);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    time = offsetTime.format(formatter);
                    updateTime.setValue(String.format("Last update time: %s", time));
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage(), e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "weather request error", error);
            }
        });
        requestQueue.add(request);
    }

    private String parseUV(JSONObject uvIndex) {
        try {
            int uvi = uvIndex.getJSONArray("data").getJSONObject(0).getInt("value");
            switch (uvi) {
                case 0:
                case 1:
                case 2:
                    return uvi + " (Low)";
                case 3:
                case 4:
                case 5:
                    return uvi + " (Moderate)";
                case 6:
                case 7:
                    return uvi + " (High)";
                case 8:
                case 9:
                case 10:
                    return uvi + " (Very High)";
                case 11:
                case 12:
                    return uvi + " (Extreme)";
                default:
                    return String.valueOf(uvi);
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseUv error", e);
        }
        return "0 (Low)";
    }

    public LiveData<String> getTemp() {
        return temp;
    }

    public LiveData<String> getHumid() {
        return humid;
    }

    public LiveData<String> getUV() {
        return uv;
    }

    public LiveData<String> getRain() {
        return rain;
    }

    public LiveData<String> getUpdateTime() {
        return updateTime;
    }
}