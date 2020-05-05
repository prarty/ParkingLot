package com.parkingSystem.commands;

import com.parkingSystem.modal.Lot;
import com.parkingSystem.modal.ParkingLot;

public class LeaveLot implements Command {
    private Lot lot;
    private ParkingLot parkingLot;

    public LeaveLot(int lotNumber, ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.lot = parkingLot.getLot(lotNumber);
    }

    @Override
    public void execute() {
        parkingLot.emptyLot(lot);
    }
}
