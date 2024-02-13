package com.weatherapp.model.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
}
