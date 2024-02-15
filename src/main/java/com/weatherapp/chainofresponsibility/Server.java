package com.weatherapp.chainofresponsibility;

import com.weatherapp.utils.CustomErrorResponse;
import com.weatherapp.exception.GeocoderException;
import com.weatherapp.exception.WeatherDataException;
import com.weatherapp.model.weather.WeatherDataObject;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Setter
@Component
public class Server {
    private Middleware middleware;

    public ResponseEntity<?> getWeatherData(String lat, String lon, String cityName) {
        WeatherDataObject data;

        try {
            data = middleware.getData(lat, lon, cityName);
        } catch (GeocoderException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomErrorResponse("Could not find the city, there may be a mistake in the name."));
        } catch (WeatherDataException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomErrorResponse("The website is down or received incorrect data from geocoder, please try again."));
        }

        if (data != null) {
            System.out.println("Data has been retrieved successfully!");
            return ResponseEntity.ok(data);
            // Enricher here
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new CustomErrorResponse("Could not find the data, please try again."));        }
    }
}
