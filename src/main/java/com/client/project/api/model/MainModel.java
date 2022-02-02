package com.client.project.api.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainModel {

    private Float temp = null;
    private Float feels_like = null;
    private Float temp_min = null;
    private Float temp_max = null;
    private Float pressure = null;
    private Integer humidity = null;
    private Integer sea_level = null;
    private Integer grnd_level = null;

}
