package com.bridgelabz;

/**
 *  Created class to notify the Airport Security when the parking lot is full.
 */
public class AirportSecurity {
    public static String message;

    //Method to update the message passed.
    public void updateMessage(String message) {
        this.message = message;
    }

    //Method to pass the message when called.
    public String getMessage() {
        return message;
    }
}
