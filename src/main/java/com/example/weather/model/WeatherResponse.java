package com.example.weather.model;

import java.util.List;

public class WeatherResponse {
    private String location;
    private List<Weather> forecasts;
    
    //default no argument constructor is required by jackson for converting json to pojo
    public WeatherResponse() {}

    public WeatherResponse(String location, List<Weather> forecasts) {
        this.location = location;
        this.forecasts = forecasts;
    }

    public String getLocation() { return location; }
    public List<Weather> getForecasts() { return forecasts; }
}
