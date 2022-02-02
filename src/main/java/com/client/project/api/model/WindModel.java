package com.client.project.api.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindModel {
    private  Float speed = null;
    private  Float deg = null;
    private  Float gust = null;
}
