package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    public static String vehicle = "Car";
    public static ParkingLot parkingLot = new ParkingLot(vehicle);


    /**UC1: Park Vehicle
    Test Case 1 -Able to Park The vehicle in the Parking Lot.
     */
    @Test
    public void givenVehicle_WhenPark_ShouldReturnTrue() {
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertTrue(parkingStatus);
    }

    /*
    Test Case 2 -Able to check weather vehicle is already parked or not.
     */
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertFalse(parkingStatus);
    }

    /** UC2 : Unpark Vehicle
     Test Case 3 - Able to Unpark the vehicle from the parking lot.
     */
    @Test
    public void givenVehicleIfParked_WhenUnParked_ShouldReturnTrue() {
        boolean parkingStatus = parkingLot.unParkVehicle(vehicle);
        assertTrue(parkingStatus);
    }

    /**UC3 : Put out the Full Sign
    Test Case 4 - when the parking lot is full, put out the full sign.
     */
    @Test
    public void givenParkingLot_IfFull_ShouldShowFullSign() {
        String parkingLotStatus = parkingLot.parkingLotStatus(vehicle);
        assertEquals("Lot is Full", parkingLotStatus);
    }

    /*
    Test Case 5 - when the parking lot is empty, show parking available.
     */
    @Test
    public void givenParkingLot_IfEmpty_ShouldShowParkingAvailableSign() {
        String parkingLotStatus = parkingLot.parkingLotStatus(null);
        assertEquals("Parking Available", parkingLotStatus);
    }

}
