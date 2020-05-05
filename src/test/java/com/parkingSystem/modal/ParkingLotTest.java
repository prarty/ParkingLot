package com.parkingSystem.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingLotTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setUpOutputStream(){
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreOriginalStream(){
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldParkInLot1(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setNoOfSlots(5);
        parkingLot.park(mock(Car.class));

        assertEquals("Allocated slot number: 1", outputStream.toString().trim());
    }

    @Test
    void shouldPrintParkingIsFullWhenNoSlotsAreAvailable() throws IOException {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setNoOfSlots(1);

        parkingLot.park(mock(Car.class));
        outputStream.reset();
        parkingLot.park(mock(Car.class));

        assertEquals("Sorry, parking lot is full", outputStream.toString().trim());
    }

    @Test
    void shouldEmptyTheSlot2(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setNoOfSlots(2);
        Lot lot = mock(Lot.class);

        parkingLot.park(mock(Car.class));
        parkingLot.park(mock(Car.class));
        outputStream.reset();

        when(lot.lotNumber()).thenReturn(2);
        parkingLot.emptyLot(lot);

        assertEquals("Slot number 2 is free", outputStream.toString().trim());
    }
}