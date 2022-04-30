package com.bridgelabz.entity;

import com.bridgelabz.IParkingObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created Class Owner To Notify When The Parking Lot Is Full.
 */
public class Owner implements IParkingObserver {
    Integer key;

    public Owner() {

    }

    int lotNumber = 1;

    public static String message;

    //Method to update the message passed.
    public void updateMessage(String message) {
        this.message = message;
    }

    //Method to pass the message when called.
    public String getMessage() {
        return message;
    }

    /**
     * In this method we will check and generate the key to park the car.
     * We will return the key to the attendant to park the car.
     * We will increment the lot number and assign the key to it.
     *
     * @param parkingMap -  we are passing the hash map here
     * @return - We will return the key to park the vehicle.
     */
    public Integer allocateSpaceToPark(Map<Integer, Car> parkingMap) {
        if (parkingMap.size() == 0)
            this.key = lotNumber;
        for (Integer key : parkingMap.keySet()) {
            this.key = key;
            if (parkingMap.get(key) == null) {
                this.key = key;
                return this.key;
            }
            if (!parkingMap.get(key).equals(key))
                this.key = lotNumber;
        }
        lotNumber++;
        return key;
    }

    /**
     * Method to update the key value for further implementations.
     */
    public void updateUnParkedVehicle(Integer key) {
        this.key = key;
    }
}
