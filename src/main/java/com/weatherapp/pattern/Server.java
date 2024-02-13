package com.weatherapp.pattern;

import com.weatherapp.model.weather.WeatherDataObject;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class Server {
    private Middleware middleware;

    public WeatherDataObject getWeatherData(String lat, String lon, String cityName) {
        WeatherDataObject data = middleware.getData(lat, lon, cityName);
        if (data != null) {
            System.out.println("Data has been retrieved successfully!");
            return data;
            // Enricher here
        }
        return null;
    }
}
