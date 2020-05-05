package com.parkingSystem.commands;

import com.parkingSystem.modal.Car;
import com.parkingSystem.modal.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ParkCarTest {
    @Test
    void shouldCallParkingLotToParkCar() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        ParkCar parkCar = new ParkCar("KA-01-HH-1234", "White", parkingLot);
        parkCar.execute();
        verify(parkingLot, times(1)).park(any(Car.class));
    }
}