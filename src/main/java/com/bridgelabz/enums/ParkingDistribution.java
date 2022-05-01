package com.bridgelabz.enums;

public enum ParkingDistribution {
    HANDICAP(2),GENERAL(5);
    public int lot;

    ParkingDistribution(int lot) {
        this.lot = lot;
    }
}
