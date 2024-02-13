package com.weatherapp.controller;

import com.weatherapp.model.weather.WeatherDataObject;
import com.weatherapp.pattern.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class ClientController {

    private final Server server;

    @GetMapping("/{cityName}")
    public WeatherDataObject getWeatherData(@PathVariable(value = "cityName") String cityName) {
        return server.getWeatherData(null, null, cityName);
    }
}
