package com.parkingSystem.modal;

public class Lot {
    private int lotNumber;
    private boolean isVacant;
    private Car car;

    Lot(){
    }
    Lot(Car car, int lotNumber) {
        this.car = car;
        isVacant = false;
        this.lotNumber = lotNumber;
    }

    boolean isEmpty() {
        return isVacant;
    }

    void parkInLot(Car car) {
        this.car = car;
        isVacant = false;
    }

    int lotNumber() {
        return lotNumber;
    }

    void unPark() {
        this.car = null;
        isVacant = true;
    }

    void carDetails() {
        this.car.details();
    }

    boolean matchCarColour(String colour) {
        return car.matchCarColour(colour);
    }

    void printCarRegistrationNumber() {
        car.printRegistrationNumber();
    }

    void printLotNumber() {
        System.out.println(lotNumber + " ");
    }

    boolean matchCarRegistrationNumber(String registrationNumber) {
        return car.compareRegistrationNumber(registrationNumber);
    }
}
