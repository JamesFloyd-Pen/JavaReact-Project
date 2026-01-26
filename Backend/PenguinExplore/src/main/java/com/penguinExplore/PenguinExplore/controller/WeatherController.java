package com.penguinExplore.PenguinExplore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    // Replace with your actual API key from https://openweathermap.org/api
    private static final String API_KEY = "2f9f1695d843f117a0269d26f307bebe";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city) {
        try {
            String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            Object weatherData = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching weather: " + e.getMessage());
        }
    }

    @GetMapping("/coordinates")
    public ResponseEntity<?> getWeatherByCoordinates(
            @RequestParam double lat, 
            @RequestParam double lon) {
        try {
            String url = BASE_URL + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            Object weatherData = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching weather: " + e.getMessage());
        }
    }
}
