package com.parkingSystem.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams(){
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldPrintCarDetails(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        car.details();

        String expectedMessage = registrationNumber+"    "+white;
        assertEquals(expectedMessage, outContent.toString().replaceAll("\n",""));
    }

    @Test
    void shouldMatchCarColourWhenCarHasSameColour(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        boolean isSame = car.matchCarColour(white);

        assertTrue(isSame);
    }

    @Test
    void shouldNotMatchCarColourWhenCarDoesNotHaveSameColour(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        boolean isSame = car.matchCarColour("Red");

        assertFalse(isSame);
    }

    @Test
    void shouldPrintRegistrationNumberWhenCarHasRegistrationNumber(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        car.printRegistrationNumber();

        assertEquals(registrationNumber, outContent.toString().trim());
    }

    @Test
    @DisplayName("should return true when registration number match")
    void shouldValidateRegistrationNumberForTrueValue(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        boolean isSame = car.compareRegistrationNumber(registrationNumber);

        assertTrue(isSame);
    }

    @Test
    @DisplayName("should return false when registration number dont match")
    void shouldValidateRegistrationNumberForFalseValue(){
        String registrationNumber = "KA-01-P-333";
        String white = "White";
        Car car = new Car(registrationNumber, white);

        boolean isSame = car.compareRegistrationNumber("KA-01-P-323");

        assertFalse(isSame);
    }
}