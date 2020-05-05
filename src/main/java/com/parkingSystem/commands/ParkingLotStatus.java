package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;

public class ParkingLotStatus implements Command {
    private ParkingLot parkingLot;

    public ParkingLotStatus(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute() {
        parkingLot.status();
    }
}
