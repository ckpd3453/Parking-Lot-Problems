package com.bridgelabz.exception;

// Custom Exception Class
public class ParkingLotException extends Exception {

    public String message;

    public ParkingLotException(String message) {

        this.message = message;
    }

}
