package com.parkingSystem.commands;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateParkingLotTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintParkingLotWith6Slots() {
        int numberOfSlots = 6;
        ParkingLot parkingLot = mock(ParkingLot.class);
        CreateParkingLot createParkingLot = new CreateParkingLot(parkingLot, numberOfSlots);
        when(parkingLot.totalSlots()).thenReturn(numberOfSlots);

        createParkingLot.execute();

        assertEquals("Created a parking lot with 6 slots", outContent.toString().replaceAll("\n", ""));
    }

}