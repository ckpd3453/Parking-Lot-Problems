package com.bridgelabz;

public class ParkingLot {
    String vehicle;

    /*
    Parameterised Constructor
     */
    public ParkingLot(String vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLot() {
    }

    /**
     * Method check if the driver is able to park the vehicle.
     *
     * @param vehicle - We are passing the String vehicle.
     * @return - Method return FALSE if parking lot is full and unable to park the vehicle OR
     * return TRUE if parking lot is empty and able to park vehicle.
     */
    public boolean parkVehicle(String vehicle) {
        if (this.vehicle != null) {
            return false;
        } else {
            this.vehicle = vehicle;
            return true;
        }
    }

    /**
     * Method to unpark the vehicle.
     *
     * @param vehicle - We are passing the String vehicle.
     * @return - Method return FALSE if vehicle is not found OR
     * will return TRUE if the vehicle found and is unparked.
     */
    public boolean unParkVehicle(String vehicle) {
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
