package com.example.weather.provider;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;

public interface WeatherProvider {

    Weather getCurrentWeather(String location);

    WeatherResponse getForecast(String location, int days);

    String getProviderName();
}
