package com.weatherapp.chainofresponsibility;

import com.weatherapp.service.GeocoderService;
import com.weatherapp.service.WeatherService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MiddlewareInit {

    private final GeocoderService geocoderService;
    private final WeatherService weatherService;
    private final Server server;

    @PostConstruct
    private void postConstruct() {
        Middleware middleware = Middleware.link(
                new GeocoderMiddleware(geocoderService),
                new WeatherMiddleware(weatherService)
        );
        server.setMiddleware(middleware);
    }
}
