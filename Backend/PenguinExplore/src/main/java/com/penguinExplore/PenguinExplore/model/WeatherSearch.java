package com.penguinExplore.PenguinExplore.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_searches")
public class WeatherSearch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private Double temperature;
    
    @Column(name = "feels_like")
    private Double feelsLike;
    
    private Integer humidity;
    
    @Column(name = "weather_description")
    private String weatherDescription;
    
    @Column(name = "wind_speed")
    private Double windSpeed;
    
    @Column(name = "search_timestamp")
    private LocalDateTime searchTimestamp;
    
    private String country;
    
    public WeatherSearch() {
        this.searchTimestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public Double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    public Double getFeelsLike() {
        return feelsLike;
    }
    
    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }
    
    public Integer getHumidity() {
        return humidity;
    }
    
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
    
    public String getWeatherDescription() {
        return weatherDescription;
    }
    
    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
    
    public Double getWindSpeed() {
        return windSpeed;
    }
    
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
    
    public LocalDateTime getSearchTimestamp() {
        return searchTimestamp;
    }
    
    public void setSearchTimestamp(LocalDateTime searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}
