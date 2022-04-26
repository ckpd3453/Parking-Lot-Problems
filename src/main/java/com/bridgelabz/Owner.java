package com.bridgelabz;

/**
 * Created Class Owner To Notify When The Parking Lot Is Full.
 */
public class Owner {
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
