package com.weatherapp.service;

import com.weatherapp.BaseTest;
import com.weatherapp.model.weather.WeatherDataObject;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTest extends BaseTest {

    @Test
    public void testGetGeocoderData() {
        //given
        String lat = "54.7101";
        String lon = "20.5105838";
        //when
        WeatherDataObject weatherData = weatherService.getWeatherDataObject(lat, lon);
        //then
        assertEquals("Kaliningrad", weatherData.getName());
    }
}
