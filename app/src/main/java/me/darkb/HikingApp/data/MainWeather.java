package me.darkb.HikingApp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainWeather {

    @SerializedName("temp")
//    @Expose(serialize = false, deserialize = false)
    private Double temp;
    @SerializedName("feels_like")
    @Expose
    private Double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private Double tempMin;
    @SerializedName("temp_max")
    @Expose
    private Double tempMax;
    @SerializedName("pressure")
//    @Expose(serialize = false, deserialize = false)
    private Integer pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;

    public Double getTemp() {
        return temp;
    }


    public Double getFeelsLike() {
        return feelsLike;
    }


    public Double getTempMin() {
        return tempMin;
    }


    public Double getTempMax() {
        return tempMax;
    }


    public Integer getPressure() {
        return pressure;
    }


    public Integer getHumidity() {
        return humidity;
    }

}
