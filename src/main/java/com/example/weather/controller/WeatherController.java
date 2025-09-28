package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherAggregatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherAggregatorService weatherService;

    public WeatherController(WeatherAggregatorService weatherService) {
        this.weatherService = weatherService;
    }

    // Current weather
    @GetMapping("/weather/current")
    public Weather getCurrentWeather(@RequestParam String location) {
        return weatherService.getCurrentWeather(location);
    }

    // Forecast
    @GetMapping("/weather/forecast")
    public WeatherResponse getForecast(@RequestParam String location,
                                       @RequestParam int days) {
        return weatherService.getForecast(location, days);
    }
}
