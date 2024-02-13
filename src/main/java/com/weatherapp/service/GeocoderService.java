package com.weatherapp.service;

import com.weatherapp.model.geocoder.GeocoderObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GeocoderService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public GeocoderObject getGeocoderData(String city) {
        return webClient.get()
                .uri(String.join("", "geo/1.0/direct?appid={apikey}&q={city}"), apiKey, city)
                .retrieve()
                .bodyToMono(GeocoderObject[].class)
                .map(responseArray -> responseArray[0])
                .block();
    }
}
