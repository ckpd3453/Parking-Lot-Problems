package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created Class Owner To Notify When The Parking Lot Is Full.
 */
public class Owner {

    public static String message;


    public Owner(String message) {
        this.message = message;
    }

    public Owner() {
    }

    //Method to pass the message when called.
    public static String getMessage() {
        return message;
    }
}
