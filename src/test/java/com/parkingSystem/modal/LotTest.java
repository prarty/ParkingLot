package com.parkingSystem.modal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LotTest {
    @Test
    void shouldHaveALotWithCarParked(){
        int lotNumber = 1;
        Car car = mock(Car.class);
        Lot lot = new Lot(car, lotNumber);

        assertFalse(lot.isEmpty());
    }

    @Test
    void shouldEmptyLotWhenCarIsUnParked(){
        int lotNumber = 1;
        Car car = mock(Car.class);
        Lot lot = new Lot(car, lotNumber);

        lot.unPark();

        assertTrue(lot.isEmpty());
    }

    @Test
    void shouldMatchCarColour(){
        int lotNumber = 1;
        Car car = mock(Car.class);
        String colour = "Red";
        Lot lot = new Lot(car, lotNumber);

        when(car.matchCarColour(colour)).thenReturn(true);

        assertTrue(lot.matchCarColour(colour));
    }
}