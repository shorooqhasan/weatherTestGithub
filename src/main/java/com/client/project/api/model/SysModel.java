package com.client.project.api.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysModel {
    private  Integer type = null;
    private  Integer  id = null;
    private  String message =null;
    private  String country = null;
    private  Integer  sunrise = null;
    private  Integer  sunset = null;
}
