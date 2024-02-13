package com.weatherapp.service;

import com.weatherapp.model.weather.WeatherDataObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public WeatherDataObject getWeatherDataObject(String lat, String lon) {
        return webClient.get()
                .uri(String.join("", "/data/2.5/weather?lat={lat}&lon={lon}&appid={appId}&units=metric"), lat, lon, apiKey)
                .retrieve()
                .bodyToMono(WeatherDataObject.class)
                .block();
    }
}
