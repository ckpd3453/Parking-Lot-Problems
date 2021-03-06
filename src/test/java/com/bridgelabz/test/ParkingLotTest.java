package com.bridgelabz.test;

import com.bridgelabz.entity.AirportSecurity;
import com.bridgelabz.entity.Car;
import com.bridgelabz.entity.Owner;
import com.bridgelabz.enums.ParkingDistribution;
import com.bridgelabz.exception.ParkingLotException;
import com.bridgelabz.service.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Owner owner;
    AirportSecurity airportSecurity;

    // Created Objects of class car
    public static Car car1 = new Car(1, "1234");
    public static Car car2 = new Car(2, "4563");
    public static Car car3 = new Car(3, "7564");
    public static Car car4 = new Car(4, "5332");

    @BeforeEach
    public void setUp() {
        parkingLot = new ParkingLot();
        airportSecurity = new AirportSecurity();
        owner = new Owner();
    }


    /**
     * UC1: Park Vehicle
     * Test Case 1 -Able to Park The vehicle in the Parking Lot.
     */
    @Test
    public void givenVehicle_WhenPark_ShouldReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        boolean isParked = parkingLot.isParked(car1);
        assertTrue(isParked);
    }

    /*
    Test Case 2 -Able to check weather vehicle is already parked or not.
     */
    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        boolean isParked = parkingLot.isParked(car1);
        assertTrue(isParked);
    }

    /**
     * UC2 : Unpark Vehicle
     * Test Case 3 - Able to Unpark the vehicle from the parking lot.
     */
    @Test
    public void givenVehicleIfParked_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        int key = 0;
        try {
            parkingLot.parkVehicle(car1);
            key = parkingLot.getVehicle(car1);
            parkingLot.unParkVehicle(key);
        } catch (ParkingLotException e) {
            boolean isUnParked = parkingLot.isUnParked(key);
            assertTrue(isUnParked);
        }
    }

    /*
     * Test Case 4 - When given different vehicle to unpark should throw exception Wrong vehicle
     */
    @Test
    public void givenVehicleIfParked_AndGivenDifferentVehicleToUnPark_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(car1);
            int key = parkingLot.getVehicle(car2);
            parkingLot.unParkVehicle(key);
        } catch (ParkingLotException e) {
            assertEquals("No Such Vehicle", e.message);
        }
    }

    /*
     * Test Case 5 - When given different vehicle to unpark should throw exception "No Such Vehicle Found"
     */
    @Test
    public void givenVehicleToUnPark_WhenNotAvailable_ShouldThrowException() {
        try {
            parkingLot.parkVehicle(car1);
            int key = parkingLot.getVehicle(car2);
            parkingLot.unParkVehicle(key);
        } catch (ParkingLotException e) {
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
            parkingLot.parkVehicle(car1);
            parkingLot.parkVehicle(car2);
            parkingLot.parkVehicle(car3);
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
            parkingLot.parkVehicle(car1);
            parkingLot.parkVehicle(car2);
            parkingLot.parkVehicle(car3);
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
            parkingLot.parkVehicle(car1);
            parkingLot.parkVehicle(car2);
            parkingLot.parkVehicle(car3);
        } catch (ParkingLotException e) {
            assertEquals("Parking Lot Is Full", airportSecurity.getMessage());
        }
    }

    /**
     * UC 5 : Notify the owner to take in Full sign.
     * Test Case 9: When space available for parking should notify the owner to take in the full signal.
     */
    @Test
    public void givenWhenSpaceAvailable_ShouldNotifyOwner_ToTakeInTheFullSign() throws ParkingLotException {
        try {
            parkingLot.parkVehicle(car1);
            parkingLot.parkVehicle(car2);
            int key = parkingLot.getVehicle(car1);
            parkingLot.unParkVehicle(key);
            int key1 = parkingLot.getVehicle(car2);
            parkingLot.unParkVehicle(key1);
            parkingLot.parkVehicle(car3);
        } catch (ParkingLotException e) {
            assertEquals("Space Available", owner.getMessage());
        }
    }

    /**
     * UC 6 : As a parking lot Owner I want a parking attendant to park cars
     * Test Case 10: As a Parking Lot Owner I want a Parking Attendant to park cars
     */
    @Test
    public void givenAttendant_WhenInstructed_ShouldParkCars_AndReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        boolean isParked = parkingLot.isParked(car2);
        assertTrue(isParked);
    }

    /*
     * Test Case 11: As a Parking Lot Owner When Parking Lot is Full should get notified.
     */
    @Test
    public void givenAttendantParkedVehicle_WhenLotIsFull_OwnerShouldBeNotified() {
        try {
            parkingLot.parkVehicle(car1);
            parkingLot.parkVehicle(car2);
            parkingLot.parkVehicle(car3);
        } catch (ParkingLotException e) {
            assertEquals("Parking Lot Is Full", owner.getMessage());
        }
    }

    /**
     * UC 7 : As a driver I want to find the car so that I can go home.
     * Test case 12 - Getting the lot number so that the driver can unpark the car.
     */
    @Test
    public void givenDriver_WhenFoundTheCar_shouldReturnLotNumber() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        int lotNumber = parkingLot.getVehicle(car2);
        assertEquals(2, lotNumber);
    }

    /*
     * Test case 13 : When the lot number is provided the driver should unpark the car.
     */
    @Test
    public void givenDriver_WhenFoundTheCar_ShouldUnparkTheCar() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        int key = parkingLot.getVehicle(car2);
        parkingLot.unParkVehicle(key);
        assertEquals("Vehicle Unparked", owner.getMessage());

    }

    /*
     *  Test case 14 : If driver unpark the car then the unpark method should return true.
     */
    @Test
    public void givenDriver_WhenFoundTheCar_ShouldUnparkTheCar_andReturnTrue() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        int key = parkingLot.getVehicle(car2);
        parkingLot.unParkVehicle(key);
        boolean isUnParked = parkingLot.isUnParked(key);
        assertTrue(isUnParked);
    }

    /**
     * UC 8 : As a Owner want to know the parking Time so that I can charge lot users.
     * Test Case 15 : If a vehicle is parked in parking lot should return the parking time.
     */
    @Test
    public void givenVehicle_whenParked_ShouldReturnParkingTime() throws ParkingLotException {
        parkingLot.parkVehicle(car1);
        LocalDateTime time;
        time = LocalDateTime.now();
        System.out.println(time.withNano(0));
        assertEquals(time.withNano(0), parkingLot.parkingTime(car1));
    }

    /**
     * UC 9 : Evenly Distribution
     * Test Case 16 : Given Cars should be parked evenly in the parking lot.
     */
    @Test
    public void givenCar_ShouldBeParked_WithEvenDistribution() throws ParkingLotException {
        parkingLot.parkVehicle(car1);                // parked the vehicle  lotNumber == 1
        int key1 = parkingLot.getVehicle(car1);

        parkingLot.parkVehicle(car2);
        int key2 = parkingLot.getVehicle(car2);      // parked the vehicle  lotNumber == 2
        parkingLot.unParkVehicle(key2);              //unparked vehicle Lot number 2 = null

        parkingLot.parkVehicle(car3);                // parked the vehicle  lotNumber == 2
        int key3 = parkingLot.getVehicle(car3);

        parkingLot.unParkVehicle(key1);              // unparked the vehicle lot number 1 == null

        parkingLot.parkVehicle(car4);                //parked vehicle lot number == 1
        int key5 = parkingLot.getVehicle(car4);

        assertEquals(key1, key5);
    }

    /**
     * UC 10 : As a Handicap Driver I want Parking Attendant to Park my Car at nearest parking lot.
     *
     * Test Case 17 : Evenly Parked Vehicle on the basis of Handicap Driver(Nearest Space) And Normal Driver.
     */
    @Test
    public void givenTypeOfDriver_ShouldParkCar_InTheirLotCategory() throws ParkingLotException {

        parkingLot.parkingReservationType(car1, ParkingDistribution.HANDICAP);
        int vehicle1 = parkingLot.getVehicle(car1);
        parkingLot.parkingReservationType(car2, ParkingDistribution.GENERAL);
        int vehicle2 = parkingLot.getVehicle(car2);
        parkingLot.parkingReservationType(car3, ParkingDistribution.GENERAL);
        int vehicle3 = parkingLot.getVehicle(car3);
        System.out.println(vehicle1 + "," + vehicle2);
        assertEquals(3, vehicle2);

    }
}