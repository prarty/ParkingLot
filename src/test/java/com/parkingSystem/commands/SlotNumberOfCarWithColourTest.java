package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SlotNumberOfCarWithColourTest {
    @Test
    void shouldCallParkingLotToGetTheCarWithRedColour() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        SlotNumberOfCarWithColour slotNumberOfCarWithColour = new SlotNumberOfCarWithColour(parkingLot
                , "Red");

        slotNumberOfCarWithColour.execute();

        verify(parkingLot).lotNumbersForCarWithColour("Red");
    }
}