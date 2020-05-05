package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SlotNumberForRegistrationNumberTest {
    @Test
    void shouldCallParkingLotToGetSlotNumberForRegistrationNumber() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        String registrationNumber = "KA-01-HH-1234";
        SlotNumberForRegistrationNumber slotNumberForRegistrationNumber = new SlotNumberForRegistrationNumber(
                parkingLot, registrationNumber);

        slotNumberForRegistrationNumber.execute();

        verify(parkingLot).slotNumber(registrationNumber);
    }
}