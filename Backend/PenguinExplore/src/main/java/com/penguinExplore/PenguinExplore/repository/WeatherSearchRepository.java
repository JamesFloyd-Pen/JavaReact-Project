package com.penguinExplore.PenguinExplore.repository;

import com.penguinExplore.PenguinExplore.model.WeatherSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherSearchRepository extends JpaRepository<WeatherSearch, Long> {
    
    // Find all searches for a specific city
    List<WeatherSearch> findByCityIgnoreCase(String city);
    
    // Find recent searches ordered by timestamp
    List<WeatherSearch> findTop10ByOrderBySearchTimestampDesc();
    
    // Find all searches ordered by timestamp
    List<WeatherSearch> findAllByOrderBySearchTimestampDesc();
}
