package com.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeocoderObject {
    private String name;
    private String lat;
    private String lon;
}
