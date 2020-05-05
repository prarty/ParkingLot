package com.parkingSystem.commands;

import com.parkingSystem.modal.Car;
import com.parkingSystem.modal.ParkingLot;

public class ParkCar implements Command {
    private Car car;
    private ParkingLot parkingLot;

    public ParkCar(String registrationNumber, String colour, ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.car = new Car(registrationNumber, colour);
    }

    @Override
    public void execute() {
        parkingLot.park(car);
    }
}
