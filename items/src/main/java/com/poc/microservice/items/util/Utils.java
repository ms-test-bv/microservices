package com.poc.microservice.items.util;

public class Utils {
    public static boolean isNumber(String data){
        if(data == null){
            return false;
        }
        try {
            Double.parseDouble(data);
            return true;
        } catch (NumberFormatException  e){
            return false;
        }
    }
}
