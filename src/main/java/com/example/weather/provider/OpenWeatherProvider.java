package com.example.weather.provider;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OpenWeatherProvider implements WeatherProvider {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public OpenWeatherProvider(RestTemplate restTemplate, @Value("${openweather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    @Cacheable(value = "currentWeather", key = "#location")
    public Weather getCurrentWeather(String location) {
        System.out.println("Fetching CURRENT weather from API for: " + location);

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" 
                   + location + "&appid=" + apiKey + "&units=metric";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        List<Map<String,Object>> weatherList = (List<Map<String,Object>>) response.get("weather");
        Map<String,Object> main = (Map<String,Object>) response.get("main");

        String desc = (String) weatherList.get(0).get("description");
        double temp = ((Number) main.get("temp")).doubleValue();

        return new Weather(location, desc, temp);
    }

    @Override
    @Cacheable(value = "forecastWeather", key = "#location + '-' + #days")
    public WeatherResponse getForecast(String location, int days) {
        System.out.println("Fetching FORECAST weather from API for: " + location);

        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" 
                   + location + "&appid=" + apiKey + "&units=metric";

        Map<String,Object> response = restTemplate.getForObject(url, Map.class);

        List<Map<String,Object>> list = (List<Map<String,Object>>) response.get("list");

        List<Weather> forecasts = list.stream()
                .limit(days)
                .map(item -> {
                    Map<String,Object> main = (Map<String,Object>) item.get("main");
                    List<Map<String,Object>> weatherList = (List<Map<String,Object>>) item.get("weather");

                    String desc = (String) weatherList.get(0).get("description");
                    double temp = ((Number) main.get("temp")).doubleValue();

                    return new Weather(location, desc, temp);
                })
                .collect(Collectors.toList());

        return new WeatherResponse(location, forecasts);
    }

    @Override
    public String getProviderName() {
        return "OpenWeatherProvider";
    }
}
