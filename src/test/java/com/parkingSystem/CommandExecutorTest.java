package com.parkingSystem;

import com.parkingSystem.commands.Command;
import com.parkingSystem.commands.CreateParkingLot;
import com.parkingSystem.commands.ParkCar;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CommandExecutorTest {

    @Test
    void shouldExecuteCreateParkingLotWhenTheCommandIsGiven() {
        CommandExecutor commandExecutor = new CommandExecutor();
        Command createParkingLot = mock(CreateParkingLot.class);
        commandExecutor.setCommand(createParkingLot);
        commandExecutor.update();
        verify(createParkingLot, times(1)).execute();
    }

    @Test
    void shouldExecuteParkCarWhenTheCommandIsGiven() {
        CommandExecutor commandExecutor = new CommandExecutor();
        Command createParkingLot = mock(ParkCar.class);
        commandExecutor.setCommand(createParkingLot);

        commandExecutor.update();

        verify(createParkingLot, times(1)).execute();
    }
}