package com.example.weather.model;

public class Weather {
    private String city;
    private String description;
    private double temperature;
    
    public Weather() {}

    public Weather(String city, String description, double temperature) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
    }

    public String getCity() { return city; }
    public String getDescription() { return description; }
    public double getTemperature() { return temperature; }
}