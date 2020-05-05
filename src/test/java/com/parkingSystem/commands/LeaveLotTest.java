package com.parkingSystem.commands;

import com.parkingSystem.modal.Lot;
import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LeaveLotTest {
    @Test
    void shouldCallParkingLotToEmptyLot() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        Lot lot = mock(Lot.class);
        when(parkingLot.getLot(1)).thenReturn(lot);
        LeaveLot leaveLot = new LeaveLot(1, parkingLot);

        leaveLot.execute();

        verify(parkingLot).emptyLot(lot);
    }
}