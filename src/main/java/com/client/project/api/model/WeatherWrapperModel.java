package com.client.project.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherWrapperModel {
    private CoordModel coord ;
    private List<WeatherModel> weather;
    private MainModel main;
    private RainModel rain;
    private SnowModel snow;
    private WindModel wind;
    private SysModel sys;
    private CloudsModel clouds;
    private String base = null;
    private Integer visibility = null;
    private Integer dt = null;
    private Integer timezone = null;
    private Integer id = null;
    private String name = null;
    private Integer cod = null;

}
