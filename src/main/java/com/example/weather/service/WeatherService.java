package com.example.weather.service;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;
import com.example.weather.provider.WeatherProvider;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final List<WeatherProvider> providers;

    public WeatherService(List<WeatherProvider> providers) {
        this.providers = providers;
    }
    
    
    @Cacheable(value="currentWeather", key="#location")
    public Weather getCurrentWeather(String location) {
        for (WeatherProvider provider : providers) {
            try {
                return provider.getCurrentWeather(location);
            } catch (Exception e) {
                // try next provider
            }
        }
        throw new RuntimeException("All providers failed for current weather: " + location);
    }

    @Cacheable(value="forecast", key="#location + ':' + #days")
    public WeatherResponse getForecast(String location, int days) {
        for (WeatherProvider provider : providers) {
            try {
            	
                return provider.getForecast(location, days);
            } catch (Exception e) {
                // try next provider
            }
        }
        throw new RuntimeException("All providers failed for forecast: " + location);
    }
}
