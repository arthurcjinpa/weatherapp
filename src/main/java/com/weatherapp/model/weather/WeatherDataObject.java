package com.weatherapp.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataObject {
    private String name;
    private Weather[] weather;
    private Main main;
}
