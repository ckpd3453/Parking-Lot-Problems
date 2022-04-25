package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    public static ParkingLot parkingLot = new ParkingLot();

    /*UC1: Park Vehicle
    Test Case 1 -Able to Park The vehicle in the Parking Lot
     */
    @Test
    public void givenVehicle_WhenPark_ShouldReturnTrue() {
        String vehicle = "Car";
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertTrue(parkingStatus);
    }

    /*
    Test Case 2 -Able to check weather vehicle is already parked or not
     */
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse(){
        String vehicle = "Car";
        boolean parkingStatus = parkingLot.parkVehicle(vehicle);
        assertFalse(parkingStatus);
    }
}
