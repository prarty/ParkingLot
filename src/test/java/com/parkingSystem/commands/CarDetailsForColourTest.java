package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CarDetailsForColourTest {
    @Test
    void shouldCallParkingLotToGetCarDetailsForWhiteColour() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        String white = "White";
        CarDetailsForColour carDetailsForColour = new CarDetailsForColour(parkingLot, white);

        carDetailsForColour.execute();

        verify(parkingLot).carDetailsWithColour(white);
    }
}