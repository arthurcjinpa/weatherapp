package com.weatherapp.controller;

import com.weatherapp.model.weather.WeatherDataObject;
import com.weatherapp.pattern.GeocoderMiddleware;
import com.weatherapp.pattern.Middleware;
import com.weatherapp.pattern.Server;
import com.weatherapp.pattern.WeatherMiddleware;
import com.weatherapp.service.GeocoderService;
import com.weatherapp.service.WeatherService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class ClientController {

    private final GeocoderService geocoderService;
    private final WeatherService weatherService;
    private final Server server;

    @GetMapping("/{cityName}")
    public WeatherDataObject getWeatherData(@PathVariable(value = "cityName") String cityName) {
        server.getWeatherData(null, null, cityName);
        return null;
    }

    @PostConstruct
    private void postConstruct() {
        Middleware middleware = Middleware.link(
                new GeocoderMiddleware(geocoderService),
                new WeatherMiddleware(weatherService)
        );

        server.setMiddleware(middleware);
    }
}
