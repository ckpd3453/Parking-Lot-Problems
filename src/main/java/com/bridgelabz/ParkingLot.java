package com.bridgelabz;

public class ParkingLot {
    String vehicle;

    /**
     *  Method check if the driver is able to park the vehicle.
     * @param vehicle - We are passing the String vehicle.
     * @return - Method return FALSE if parking lot is full and unable to park the vehicle OR
     * return TRUE if parking lot is empty and able to park vehicle.
     */
    public boolean parkVehicle(String vehicle) {
        if(this.vehicle != null) {
            return false;
        }else {
            this.vehicle = vehicle;
            return true;
        }
    }
}
