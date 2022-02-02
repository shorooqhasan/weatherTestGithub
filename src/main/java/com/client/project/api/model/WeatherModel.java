package com.client.project.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class WeatherModel {
    //private List<String> weather = new ArrayList<>();

    private Integer id = null;
    private String main = null;
    private String description = null;
    private String icon = null;

   // ArrayList<String> listOfStrings = new ArrayList<String>(main,description,icon);
   // ArrayList<Integer> listOfIntegers = new ArrayList<Integer>(id);
   // List<List> weather = new ArrayList<List>(listOfIntegers,listOfStrings);


  //  private List<String> weather =new ArrayList<String>( id,main,description,icon);


}

