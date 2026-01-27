package com.penguinExplore.PenguinExplore.service;

import com.penguinExplore.PenguinExplore.model.WeatherSearch;
import com.penguinExplore.PenguinExplore.repository.WeatherSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    
    @Autowired
    private WeatherSearchRepository repository;
    
    /**
     * Save weather search data from API response
     */
    public WeatherSearch saveWeatherSearch(Map<String, Object> weatherData) {
        WeatherSearch search = new WeatherSearch();
        
        // Extract city name
        if (weatherData.containsKey("name")) {
            search.setCity((String) weatherData.get("name"));
        }
        
        // Extract country from sys object
        if (weatherData.containsKey("sys")) {
            Map<String, Object> sys = (Map<String, Object>) weatherData.get("sys");
            if (sys.containsKey("country")) {
                search.setCountry((String) sys.get("country"));
            }
        }
        
        // Extract main weather data
        if (weatherData.containsKey("main")) {
            Map<String, Object> main = (Map<String, Object>) weatherData.get("main");
            
            if (main.containsKey("temp")) {
                search.setTemperature(((Number) main.get("temp")).doubleValue());
            }
            if (main.containsKey("feels_like")) {
                search.setFeelsLike(((Number) main.get("feels_like")).doubleValue());
            }
            if (main.containsKey("humidity")) {
                search.setHumidity(((Number) main.get("humidity")).intValue());
            }
        }
        
        // Extract weather description
        if (weatherData.containsKey("weather")) {
            List<Map<String, Object>> weatherList = (List<Map<String, Object>>) weatherData.get("weather");
            if (!weatherList.isEmpty()) {
                Map<String, Object> weather = weatherList.get(0);
                if (weather.containsKey("description")) {
                    search.setWeatherDescription((String) weather.get("description"));
                }
            }
        }
        
        // Extract wind speed
        if (weatherData.containsKey("wind")) {
            Map<String, Object> wind = (Map<String, Object>) weatherData.get("wind");
            if (wind.containsKey("speed")) {
                search.setWindSpeed(((Number) wind.get("speed")).doubleValue());
            }
        }
        
        return repository.save(search);
    }
    
    /**
     * Get all weather searches
     */
    public List<WeatherSearch> getAllSearches() {
        return repository.findAllByOrderBySearchTimestampDesc();
    }
    
    /**
     * Get recent 10 searches
     */
    public List<WeatherSearch> getRecentSearches() {
        return repository.findTop10ByOrderBySearchTimestampDesc();
    }
    
    /**
     * Get searches for a specific city
     */
    public List<WeatherSearch> getSearchesByCity(String city) {
        return repository.findByCityIgnoreCase(city);
    }
}
