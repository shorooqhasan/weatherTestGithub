package com.client.project.api.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WeatherCalculationsAnalysis {
    public static boolean evaluateValueIsPercentage(Float number) {
        boolean percentage;
        Float n = number/100;
       //System.out.println("percentage" + n.toString() );
        if (number/100 >=  0 ) {
            return percentage = true;
        } else {
            return percentage = false;
        }
    }

    public static String verifyValueIsNotNegative(Float number) {
        if (number < 0) {
            return "negative";
        } else {
            return "positive";
        }
    }
    public static String verifyValueIsNotNegative(Integer number) {
        if (number < 0) {
            return "negative";
        } else {
            return "positive";
        }
    }

    public static String verifyValueXnotExceedingValueY(Integer number1, Integer number2) {
        if (number1 > number2) {
            return "Test is passed";
        } else {
            return "Test is failed";
        }
    }

    public static String getDateAndTime(Integer timeStamp) {
        java.util.Date dateTime = new java.util.Date(timeStamp);
        return dateTime.toString();
    }

    //returns :  Tue Feb 01 05:45:33 CET 2022 as an example
    public static String getDateAndTime2(Integer timeStamp) {
        Instant instant = Instant.ofEpochSecond( timeStamp );
        Date date = Date.from( instant );
        return date.toString();
    }

    public static String getDate(Integer timeStamp) {
        Instant instant = Instant.ofEpochSecond( timeStamp );
        Date date = Date.from( instant );
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String newDateFormat = formatter.format(date);
        //System.out.println("new date:"+ newDateFormat);
        String subStringDate = newDateFormat.substring(0,10);
      return  subStringDate;
    }

    //Takes String Date and time returns only the time
    public static String getTime(String DateAndTime) {
        String subStringDate = DateAndTime.substring(11,18);
        return  subStringDate;
    }

    public static String verifySunRiseTime(String time) {
        Integer timeConverted = Integer.valueOf(time.substring(0, 2));
        //System.out.println("time converted is " +timeConverted);
        if (timeConverted < 12 && timeConverted > 0) {
            return "true";
        } else {
            return "false";
        }
    }
    public static String verifySunSetTime(String time) {
        Integer sunsetTimeConverted = Integer.valueOf(time.substring(0,2)) ;
        if (sunsetTimeConverted > 12 && sunsetTimeConverted < 24) {
            return "true";
        } else {
            return "false";
        }
    }

    public static String getTodayDate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }

    public  static String getMaxTempValueIsLessThanTheMaximum(Float maxTemp) {

        if (maxTemp < 50) {
            return "true";
        } else {
            return "false";
        }
    }
    public static   String getMinTempValueIsGreaterThanTheMinimum(Float minTemp) {

        if (minTemp > -50) {
            return "true";
        } else {
            return "false";
        }
    }
}
