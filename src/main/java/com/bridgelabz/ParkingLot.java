package com.bridgelabz;

public class ParkingLot {
    private Object vehicle = null;

    /**
     *  Method to park the Vehicle.
     *  If the parking lot is null then the object will be initialized to the local object vehicle.
     *  If the local object vehicle is not null then it will throw the exception.
     *
     * @param vehicle - We are passing the Object Vehicle
     * @throws ParkingLotException - If the parking lot is != NULL then it will throw the Custom Exception as "Parking Lot is Full".
     */
    public void parkVehicle(Object vehicle) throws ParkingLotException {
        if (this.vehicle != null)
            throw new ParkingLotException("Parking Lot is Full");
        this.vehicle = vehicle;
    }

    /**
     *  Method to Unpark the Vehicle.
     *  If the vehicle is present in the parking lot then it will make the local Object to "null".
     *  If the vehicle is not present then it will throw the Custom Exception.
     *
     * @param vehicle -  We are passing the Object Vehicle
     * @throws ParkingLotException - If we are trying to unpark the different vehicle then it will throw the exception "No Such Vehicle"
     */
    public void unParkVehicle(Object vehicle) throws ParkingLotException {
        if (vehicle != vehicle)
            throw new ParkingLotException("No Such Vehicle");
        if (this.vehicle != null && this.vehicle.equals(vehicle))
            this.vehicle = null;
    }

    /**
     *  Query Statement - Method to check if the vehicle is parked or not.
     *
     * @param vehicle -  We are passing the Object Vehicle
     * @return -  Will return true if vehicle is parked.
     */
    public boolean isParked(Object vehicle) {
        return this.vehicle == vehicle;
    }

    /**
     * Query Statement - Method to check if the vehicle is Unparked or not.
     * @return - Will return true if the vehicle is Unparked and Object is null.
     */
    public boolean isUnParked() {
        return this.vehicle == null;
    }
}