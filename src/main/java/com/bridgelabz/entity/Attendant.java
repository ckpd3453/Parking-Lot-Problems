package com.bridgelabz.entity;

import java.util.Map;

/**
 * Class attendant is taken as entity which follows the instruction of the owner to park the vehicle.
 */
public class Attendant {

    public Attendant() {
    }

    Owner owner = new Owner();
    /**
     * Method park vehicle will call the owner class to get the key number for the handicap user.
     *
     * @param parkingMap - Passing the hash map
     * @return - will return the key generated from the owner.
     */
    public Integer handicapParkVehicle(Map<Integer, Car> parkingMap) {
        return owner.allocateSpaceToPark(parkingMap);
    }

    /**
     * Method park vehicle will call the owner class to get the key number for normal user.
     *
     * @param parkingMap - Passing the hash map
     * @return - will return the key generated from the owner.
     */
    public Integer generalParkVehicle(Map<Integer, Car> parkingMap) {
        return owner.allocateSpaceToGeneral(parkingMap);
    }
}
