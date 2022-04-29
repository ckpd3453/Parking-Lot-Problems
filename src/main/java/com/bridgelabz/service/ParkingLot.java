package com.bridgelabz.service;


import com.bridgelabz.entity.Attendant;
import com.bridgelabz.entity.Car;
import com.bridgelabz.exception.ParkingLotException;
import com.bridgelabz.entity.AirportSecurity;
import com.bridgelabz.entity.Owner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int PARKING_LOT_CAPACITY = 2;
    public final Map<Integer, Car> parkingMap = new HashMap<>();
    Owner owner = new Owner();
    Attendant attendant = new Attendant();

    /**
     * Method to park the Vehicle.
     * In this we are just checking the hash map size and the parking lot capacity and parking the Car accordingly and
     * giving notifications to the authorised entities.
     *
     * @param car - We are passing the car
     * @throws ParkingLotException - If the hash map size is less that the parking lot capacity,
     *                             then we will add the car to the hash map and park the vehicle and throw exception "Space Available".
     *                             If the hash map size is greater then we will throw exception as "Parking Lot Is Full".
     */
    public void parkVehicle(Car car) throws ParkingLotException {
        if (this.parkingMap.size() < PARKING_LOT_CAPACITY) {
            Integer key = attendant.parkVehicle(parkingMap);
            parkingMap.put(key, car);
            notifyToSystem("Space Available");
        } else if (this.parkingMap.size() >= PARKING_LOT_CAPACITY) {
            this.notifyToSystem("Parking Lot Is Full");
            throw new ParkingLotException("Parking Lot Is Full");
        }
    }

    /**
     * Method to Unpark the Vehicle.
     * We are getting input as key to find the vehicle and if present,
     * then will remove the key value from the hashmap.
     * And notifying the status of the parking lot to the authorised entity
     *
     * @param key -  We are passing the key as parking lot number of object.
     * @throws ParkingLotException - We are throwing the exception if found.
     */
    public void unParkVehicle(int key) throws ParkingLotException {
        if (key == 0)
            throw new ParkingLotException("No Such Vehicle");
        if (parkingMap.size() == 0)
            throw new ParkingLotException("Parking Lot Is Empty");
        if (!parkingMap.containsKey(key))
            throw new ParkingLotException("Wrong Vehicle");
        if(this.parkingMap.size() <= PARKING_LOT_CAPACITY-1)
            notifyToSystem("Space Available");
        if (parkingMap.containsKey(key)){
            owner.updateUnParkedVehicle(key);
            parkingMap.remove(key);
            notifyToSystem("Vehicle Unparked");
        }
    }

    /**
     * Query Statement - Method to check if the vehicle is parked or not.
     * If the Hash map key contains car id then the car is parked and will return true.
     *
     * @param car -  We are passing the car
     * @return -  Will return true if vehicle is parked.
     */
    public boolean isParked(Car car) {
        return parkingMap.containsKey(car.getID());
    }

    /**
     * Query Statement - Method to check if the vehicle is Unparked or not.
     * If the Hash map key does not contains car id then the car is Unparked and will return true.
     *
     * @return - Will return true if the vehicle is Unparked
     */
    public boolean isUnParked(Car car) {
        return !parkingMap.containsKey(car.getID());
    }

    /**
     * Method to find the lot number of the vehicle if parked in the parking lot.
     * Iterating hashmap and equating each value of hashmap to the car if matched then return key as lot number of car.
     *
     * @param car - Passing car to find the key as parking lot number
     * @return - Will return key as lot number if car present in the lot.
     */
    public int getVehicle(Car car) {
        for (int key : parkingMap.keySet()) {
            if (parkingMap.get(key) == car)
                return key;
        }
        return 0;
    }

    /**
     * Method To Update Message To The Concern Entities
     */
    public void notifyToSystem(String message) {
        Owner owner = new Owner();
        AirportSecurity airportSecurity = new AirportSecurity();
        owner.updateMessage(message);
        airportSecurity.updateMessage(message);
    }
}