package com.client.project.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class WeatherModel {

    private Integer id = null;
    private String main = null;
    private String description = null;
    private String icon = null;



}

