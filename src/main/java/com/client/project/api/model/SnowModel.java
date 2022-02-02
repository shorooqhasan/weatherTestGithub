package com.client.project.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnowModel {
    @JsonProperty("1h")
    private Float snowInOneHour = null;
    @JsonProperty("3h")
    private Float snowInThreeHours = null;
}
