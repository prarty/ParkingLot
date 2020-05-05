package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;

public class SlotNumberForRegistrationNumber implements Command {
    private final String registrationNumber;
    private final ParkingLot parkingLot;

    public SlotNumberForRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute() {
        parkingLot.slotNumber(registrationNumber);
    }
}
