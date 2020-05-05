package com.parkingSystem.modal;

public class Car {
    private String registrationNumber;
    private String colour;

    public Car(String registrationNumber, String colour) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    void details() {
        System.out.println(this.registrationNumber + "    " + this.colour);
    }

    boolean matchCarColour(String colour) {
        return this.colour.toLowerCase().equals(colour.toLowerCase());
    }

    void printRegistrationNumber() {
        System.out.println(registrationNumber + " ");
    }

    boolean compareRegistrationNumber(String registrationNumber) {
        return this.registrationNumber.toLowerCase().equals(registrationNumber.toLowerCase());
    }
}
