package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;

public class CreateParkingLot implements Command {
    private ParkingLot parkingLot;
    private int slots;

    public CreateParkingLot(ParkingLot parkingLot, int slots) {
        this.parkingLot = parkingLot;
        this.slots = slots;
    }

    @Override
    public void execute() {
        parkingLot.setNoOfSlots(slots);
        System.out.println("Created a parking lot with " + parkingLot.totalSlots() + " slots");
    }
}
