package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherAggregatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherViewController {

    private final WeatherAggregatorService weatherService;

    public WeatherViewController(WeatherAggregatorService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // points to index.html in templates
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam String location,
                             @RequestParam(required = false, defaultValue = "3") int days,
                             Model model) {
        Weather current = weatherService.getCurrentWeather(location);
        WeatherResponse forecast = weatherService.getForecast(location, days);

        model.addAttribute("location", location);
        model.addAttribute("current", current);
        model.addAttribute("forecast", forecast.getForecasts());
        
       // model.addAttribute("weatherType", current.getDescription().toLowerCase());

        return "weather"; // points to weather.html in templates
    }
}
