package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;

public class CarDetailsForColour implements Command {
    private ParkingLot parkingLot;
    private String colour;

    public CarDetailsForColour(ParkingLot parkingLot, String colour) {
        this.parkingLot = parkingLot;
        this.colour = colour;
    }

    @Override
    public void execute() {
        parkingLot.carDetailsWithColour(colour);
    }
}
