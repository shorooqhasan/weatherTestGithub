package com.client.project.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RainModel {
    @JsonProperty("1h")
    private Float weatherInOneHour =null;
    @JsonProperty("3h")
    private Float weatherInThreeHours =null;



}
