package com.penguinExplore.PenguinExplore.controller;

import com.penguinExplore.PenguinExplore.model.WeatherSearch;
import com.penguinExplore.PenguinExplore.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Replace with your actual API key from https://openweathermap.org/api
    private static final String API_KEY = "2f9f1695d843f117a0269d26f307bebe";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city) {
        try {
            String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> weatherData = restTemplate.getForObject(url, Map.class);
            
            // Save the weather search to database
            if (weatherData != null) {
                weatherService.saveWeatherSearch(weatherData);
            }
            
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
            Map<String, Object> weatherData = restTemplate.getForObject(url, Map.class);
            
            // Save the weather search to database
            if (weatherData != null) {
                weatherService.saveWeatherSearch(weatherData);
            }
            
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching weather: " + e.getMessage());
        }
    }
    
    @GetMapping("/history")
    public ResponseEntity<List<WeatherSearch>> getSearchHistory() {
        return ResponseEntity.ok(weatherService.getAllSearches());
    }
    
    @GetMapping("/history/recent")
    public ResponseEntity<List<WeatherSearch>> getRecentSearches() {
        return ResponseEntity.ok(weatherService.getRecentSearches());
    }
    
    @GetMapping("/history/city/{city}")
    public ResponseEntity<List<WeatherSearch>> getCityHistory(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getSearchesByCity(city));
    }
}
