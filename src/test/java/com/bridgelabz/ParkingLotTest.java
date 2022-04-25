package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    public static String vehicle = "Car";
    public static ParkingLot parkingLot = new ParkingLot(vehicle);


    /*UC1: Park Vehicle
    Test Case 1 -Able to Park The vehicle in the Parking Lot
     */
    @Test
    public void givenVehicle_WhenPark_ShouldReturnTrue() {
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertTrue(parkingStatus);
    }

    /*
    Test Case 2 -Able to check weather vehicle is already parked or not
     */
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertFalse(parkingStatus);
    }

    /* UC2 : Unpark Vehicle
     Test Case 3 - Able to Unpark the vehicle from the parking lot.
     */
    @Test
    public void givenVehicleIfParked_WhenUnParked_ShouldReturnTrue() {
        boolean parkingStatus = parkingLot.unParkVehicle(vehicle);
        assertTrue(parkingStatus);
    }
}
