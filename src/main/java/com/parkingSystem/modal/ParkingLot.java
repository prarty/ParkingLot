package com.parkingSystem.modal;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParkingLot {
    private int noOfSlots;
    private ArrayList<Lot> slots;
    private int availableLot;

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
        this.availableLot = noOfSlots;
        this.slots = new ArrayList<>(noOfSlots);
    }

    public void park(Car car) {
        if (availableLot == 0) {
            System.out.println("Sorry, parking lot is full");
        } else {
            int lotNumber;
            Lot emptyLot = slots.stream().filter(Lot::isEmpty).findFirst().orElse(null);
            //Initializing lot one by one
            if (emptyLot == null) {
                slots.add(new Lot(car, slots.size() + 1));
                lotNumber = slots.size();
            }
            //To find empty lot in between
            else {
                emptyLot.parkInLot(car);
                lotNumber = emptyLot.lotNumber();
            }
            availableLot--;
            System.out.println("Allocated slot number: " + lotNumber);
        }
    }

    public Lot getLot(int lotNumber) {
        return slots.get(lotNumber - 1);
    }

    public void emptyLot(Lot lot) {
        Lot lotToUnParkCarFrom = slots.stream().filter(lot1 -> (lot1.lotNumber() == lot.lotNumber())).findFirst().get();
        lotToUnParkCarFrom.unPark();
        availableLot++;
        System.out.println("Slot number " + (lotToUnParkCarFrom.lotNumber()) + " is free");
    }

    public void status() {
        slots.stream().filter((lot) -> !lot.isEmpty()).forEach((lot) -> {
            System.out.print((lot.lotNumber()) + "   ");
            lot.carDetails();
        });
    }

    public void carDetailsWithColour(String colour) {
        Supplier<Stream<Lot>> lotStream = getSlotStreamWithCarColour(colour);
        if (lotStream.get().count() > 0) {
            lotStream.get().forEach(Lot::printCarRegistrationNumber);
        } else {
            System.out.println("Not Found");
        }
    }

    public void lotNumbersForCarWithColour(String colour) {
        Supplier<Stream<Lot>> lotStream = getSlotStreamWithCarColour(colour);
        if (lotStream.get().count() > 0) {
            lotStream.get().forEach(Lot::printLotNumber);
        } else {
            System.out.println("Not Found");
        }
    }

    public void slotNumber(String registrationNumber) {
        Supplier<Stream<Lot>> lotStream = () -> slots.stream()
                .filter(lot -> (!lot.isEmpty() && lot.matchCarRegistrationNumber(registrationNumber)));
        if (lotStream.get().count() > 0) {
            lotStream.get().forEach(Lot::printLotNumber);
        } else {
            System.out.println("Not Found");
        }
    }

    public int totalSlots() {
        return noOfSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return noOfSlots == that.noOfSlots &&
                availableLot == that.availableLot &&
                Objects.equals(slots, that.slots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfSlots, slots, availableLot);
    }

    private Supplier<Stream<Lot>> getSlotStreamWithCarColour(String colour) {
        return () -> slots.stream()
                .filter(lot -> (!lot.isEmpty() && lot.matchCarColour(colour)));
    }
}
