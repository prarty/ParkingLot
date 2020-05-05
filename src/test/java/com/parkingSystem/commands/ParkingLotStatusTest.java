package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ParkingLotStatusTest {

    @Test
    void shouldCallParkingLotToGetStatus() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        ParkingLotStatus parkingLotStatus = new ParkingLotStatus(parkingLot);

        parkingLotStatus.execute();

        verify(parkingLot, times(1)).status();
    }
}