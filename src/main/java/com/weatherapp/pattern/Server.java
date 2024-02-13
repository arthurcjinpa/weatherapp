package com.weatherapp.pattern;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class Server {
    private Middleware middleware;

    public void getWeatherData(String lat, String lon, String cityName) {
        if (middleware.getData(lat, lon, cityName)) {
            System.out.println("Data has been retrieved successfully!");

            // Enricher here
        }
    }
}
