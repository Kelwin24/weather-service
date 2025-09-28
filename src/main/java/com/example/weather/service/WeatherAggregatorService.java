package com.example.weather.service;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;
import com.example.weather.provider.WeatherProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherAggregatorService {

    private final WeatherProvider provider;

    public WeatherAggregatorService(WeatherProvider provider) {
        this.provider = provider;
    }

    @Cacheable(value="currentWeather", key="#location")
    public Weather getCurrentWeather(String location) {
        return provider.getCurrentWeather(location);
    }

    @Cacheable(value="forecast", key="#location + ':' + #days")
    public WeatherResponse getForecast(String location, int days) {
        return provider.getForecast(location, days);
    }
}
