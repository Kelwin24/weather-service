package com.example.weather.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final List<String> cities = Arrays.asList("Chennai", "Bangalore", "Delhi", "Mumbai");

    @GetMapping("/search")
    public List<String> search(@RequestParam String q) {
        return cities.stream()
                .filter(c -> c.toLowerCase().contains(q.toLowerCase()))
                .collect(Collectors.toList());
    }
}
