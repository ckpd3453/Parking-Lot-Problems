package com.bridgelabz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    ParkingLot parkingLot = null;
    Object vehicle1 = null;
    Object vehicle2 = null;
    Owner owner = null;
    AirportSecurity airportSecurity = null;

    //Setting up the objects.
    @BeforeEach
    public void initilization() {
        parkingLot = new ParkingLot();
        vehicle1 = new Object();
        vehicle2 = new Object();
        owner = new Owner();
        airportSecurity = new AirportSecurity();
    }

    /**
     * UC1: Park Vehicle
     * Test Case 1 -Able to Park The vehicle in the Parking Lot.
     */
    @Test
    public void givenVehicle_WhenPark_ShouldReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(vehicle1);
        boolean isParked = parkingLot.isParked(vehicle1);
        assertTrue(isParked);
    }

    /*
    Test Case 2 -Able to check weather vehicle is already parked or not.
     */
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse() throws ParkingLotException {
        try {
            parkingLot.parkVehicle(vehicle1);
            parkingLot.parkVehicle(vehicle2);
        } catch (ParkingLotException e) {
            assertEquals("Parking Lot Is Full", e.message);
        }
    }

    /*
     * UC2 : Unpark Vehicle
     * Test Case 3 - Able to Unpark the vehicle from the parking lot.
     */
    @Test
    public void givenVehicleIfParked_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(vehicle1);
        parkingLot.unParkVehicle(vehicle1);
        boolean isUnParked = parkingLot.isUnParked();
        assertTrue(isUnParked);
    }

    /*
     * Test Case 4 - When given different vehicle to unpark should return false.
     */
    @Test
    public void givenVehicleIfParked_AndGivenDifferentVehicleToUnPark_ShouldReturnFalse() throws ParkingLotException {
        parkingLot.parkVehicle(vehicle1);
        parkingLot.unParkVehicle(vehicle2);
        boolean parkingStatus = parkingLot.isUnParked();
        assertFalse(parkingStatus);
    }

    /*
     * Test Case 5 - When given different vehicle to unpark should throw exception "No Such Vehicle Found"
     */
    @Test
    public void givenVehicleToUnPark_WhenNotAvailable_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(vehicle1);
            parkingLot.unParkVehicle(vehicle2);
        } catch (ParkingLotException e) {
            System.out.println(e.message);
            assertEquals("No Such Vehicle", e.message);
        }
    }

    /**
     * UC3 : Put out the Full Sign
     * Test Case 6 - when the parking lot is full, put out the full sign.
     */
    @Test
    public void givenParkingLot_IfFull_ShouldThrowException_LotIsFull() {
        try {
            parkingLot.parkVehicle(vehicle1);
            parkingLot.parkVehicle(vehicle2);
        } catch (ParkingLotException e) {
            System.out.println(e.message);
            assertEquals("Parking Lot Is Full", e.message);
        }
    }

    /*
     * Test case 7 : When the parking lot is full then Owner should be notified.
     */
    @Test
    public void givenVehicleToPark_WhenLotFull_ShouldNotifyOwner() {
        try {
            parkingLot.parkVehicle(vehicle1);
            parkingLot.parkVehicle(vehicle2);
        } catch (ParkingLotException e) {
            assertEquals("Parking Lot Is Full", owner.getMessage());
        }
    }

    /**
     * UC4 : Notify To Airport Security
     * Test case 8 : When the parking lot is full then notify the Airport Security .
     */
    @Test
    public void givenVehicleToPark_WhenLotFull_ShouldNotifyAirportSecurity() {
        try {
            parkingLot.parkVehicle(vehicle1);
            parkingLot.parkVehicle(vehicle2);
        } catch (ParkingLotException e) {
            assertEquals("Parking Lot Is Full", airportSecurity.getMessage());
        }
    }
}