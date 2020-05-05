package com.parkingSystem;

import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingManagementSystemTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldReturnParkingLotWith6Slots() {
        String numberOfSlots = "6";
        System.setIn(new ByteArrayInputStream(numberOfSlots.getBytes()));
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        CommandExecutor commandExecutor = new CommandExecutor();
        String command = "create_parking_lot";

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);

        assertEquals("Created a parking lot with 6 slots", outputStream.toString().trim());
    }

    @Test
    @DisplayName("Execute all the commands " +
            "create_parking_lot " +
            "park leave status " +
            "registration_numbers_for_cars_with_colour" +
            "slot_numbers_for_cars_with_colour" +
            "slot_number_for_registration_number")
    void shouldExecuteAllTheCommands() {
        System.setIn(new ByteArrayInputStream(getInputSet()));
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        CommandExecutor commandExecutor = new CommandExecutor();
        //Create Parking Lot command
        String command = "create_parking_lot";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Created a parking lot with 6 slots", outputStream.toString().trim());
        //reset output stream
        outputStream.reset();

        //Park command
        command = "park";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 1", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 2", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 3", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 4", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 5", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 6", outputStream.toString().trim());
        outputStream.reset();

        //Leave command
        command = "leave";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Slot number 4 is free", outputStream.toString().trim());
        outputStream.reset();

        //Status command
        command = "status";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals(statusCommandExpectedOutput(), outputStream.toString().trim());
        outputStream.reset();

        //Park command
        command = "park";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Allocated slot number: 4", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Sorry, parking lot is full", outputStream.toString().trim());
        outputStream.reset();

        //registration_numbers_for_cars_with_colour command
        command = "registration_numbers_for_cars_with_colour";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals(getExpectedRegistrationNumbers(), outputStream.toString().trim());
        outputStream.reset();

        //slot_numbers_for_cars_with_colour command
        command = "slot_numbers_for_cars_with_colour";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals(getExpectedSlotNumbers(), outputStream.toString().trim());
        outputStream.reset();

        //slot_number_for_registration_number
        command = "slot_number_for_registration_number";
        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("6", outputStream.toString().trim());
        outputStream.reset();

        ParkingManagementSystem.execute(input, parkingLot, commandExecutor, command);
        assertEquals("Not Found", outputStream.toString().trim());
    }

    private String getExpectedSlotNumbers() {
        return "1 \n" +
                "2 \n" +
                "4";
    }

    private String getExpectedRegistrationNumbers() {
        return "KA-01-HH-1234 \n" +
                "KA-01-HH-9999 \n" +
                "KA-01-P-333";
    }

    private String statusCommandExpectedOutput() {
        return "1   KA-01-HH-1234    White\n" +
                "2   KA-01-HH-9999    White\n" +
                "3   KA-01-BB-0001    Black\n" +
                "5   KA-01-HH-2701    Blue\n" +
                "6   KA-01-HH-3141    Black";
    }

    private byte[] getInputSet() {
        String numberOfSlots = "6";
        String registrationNumber = "KA-01-HH-1234";
        String registrationNumber1 = "KA-01-HH-9999";
        String registrationNumber2 = "KA-01-BB-0001";
        String registrationNumber3 = "KA-01-HH-7777";
        String registrationNumber4 = "KA-01-HH-2701";
        String registrationNumber5 = "KA-01-HH-3141";
        String registrationNumber6 = "KA-01-P-333";
        String registrationNumber7 = "DL-12-AA-9999";
        String registrationNumber8 = "MH-04-AY-1111";
        String colour = "White";
        String colour2 = "Black";
        String colour3 = "Red";
        String colour4 = "Blue";
        String colour5 = "Black";
        String slotToLeave = "4";
        String input = numberOfSlots + separator() + registrationNumber + separator() + colour
                + separator() + registrationNumber1 + separator() + colour + separator() + registrationNumber2
                + separator() + colour2 + separator() + registrationNumber3 + separator() + colour3
                + separator() + registrationNumber4 + separator() + colour4 + separator() + registrationNumber5
                + separator() + colour5 + separator() + slotToLeave + separator() + registrationNumber6
                + separator() + colour + separator() + registrationNumber7 + separator() + colour
                + separator() + colour + separator() + colour + separator() + registrationNumber5
                + separator() + registrationNumber8;

        return input.getBytes();
    }

    private String separator() {
        return System.getProperty("line.separator");
    }
}