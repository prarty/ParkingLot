package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;

public class SlotNumberOfCarWithColour implements Command {
    private String colour;
    private ParkingLot parkingLot;

    public SlotNumberOfCarWithColour(ParkingLot parkingLot, String colour) {
        this.colour = colour;
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute() {
        parkingLot.lotNumbersForCarWithColour(colour);
    }
}
