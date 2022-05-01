package com.bridgelabz.entity;

import com.bridgelabz.IParkingObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created Class Owner To Notify When The Parking Lot Is Full.
 */
public class Owner implements IParkingObserver {
    Integer key;
    int handicapLotNumber = 1;
    int generalLotNumber = 3;

    public Owner() {

    }
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
     * In this method we will check and generate the key to park the car for handicap user.
     * We will return the key to the attendant to park the car.
     * We will increment the lot number and assign the key to it.
     *
     * @param parkingMap -  we are passing the hash map here
     * @return - We will return the key to park the vehicle.
     */
    public Integer allocateSpaceToPark(Map<Integer, Car> parkingMap) {
        if (parkingMap.size() == 0)
            this.key = handicapLotNumber;
        for (Integer key : parkingMap.keySet()) {
            this.key = key;
            if (parkingMap.get(key) == null) {
                this.key = key;
                return this.key;
            }
            if (!parkingMap.get(key).equals(key))
                this.key = handicapLotNumber;
        }
        handicapLotNumber++;
        return key;
    }

    /**
     * In this method we will check and generate the key to park the  for normal user..
     * We will return the key to the attendant to park the car.
     * We will increment the lot number and assign the key to it.
     *
     * @param parkingMap -  we are passing the hash map here
     * @return - We will return the key to park the vehicle.
     */
    public Integer allocateSpaceToGeneral(Map<Integer, Car> parkingMap) {
        if (parkingMap.size() <= 2)
            this.key = generalLotNumber;
        for (Integer key : parkingMap.keySet()) {
            this.key = key;
            if (parkingMap.get(key) == null) {
                this.key = key;
                return this.key;
            }
            if (!parkingMap.get(key).equals(key))
                this.key = generalLotNumber;
        }
        generalLotNumber++;
        return key;
    }

    /**
     * Method to update the key value for further implementations.
     */
    public void updateUnParkedVehicle(Integer key) {
        this.key = key;
    }
}
