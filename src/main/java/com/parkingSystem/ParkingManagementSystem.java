package com.parkingSystem;

import com.parkingSystem.commands.*;
import com.parkingSystem.modal.ParkingLot;

import java.util.Scanner;

public class ParkingManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        CommandExecutor commandExecutor = new CommandExecutor();
        System.out.println("Enter exit to stop");
        String command;
            do {
                command = input.next();
                execute(input, parkingLot, commandExecutor, command);
            } while (!"exit".equals(command));
    }

    static void execute(Scanner input, ParkingLot parkingLot, CommandExecutor commandExecutor, String command) {
        switch (command) {
            case "create_parking_lot":
                int slots = input.nextInt();
                Command createParkingLot = new CreateParkingLot(parkingLot, slots);
                commandExecutor.setCommand(createParkingLot);
                commandExecutor.update();
                break;
            case "park":
                String registrationNumber = input.next();
                String colour = input.next();
                Command parkCar = new ParkCar(registrationNumber, colour, parkingLot);
                commandExecutor.setCommand(parkCar);
                commandExecutor.update();
                break;
            case "leave":
                int lotNumber = input.nextInt();
                Command leaveLot = new LeaveLot(lotNumber, parkingLot);
                commandExecutor.setCommand(leaveLot);
                commandExecutor.update();
                break;
            case "status":
                Command status = new ParkingLotStatus(parkingLot);
                commandExecutor.setCommand(status);
                commandExecutor.update();
                break;
            case "registration_numbers_for_cars_with_colour":
                String colourOfCar = input.next();
                Command registrationNumbersForCarWithColour = new CarDetailsForColour(parkingLot, colourOfCar);
                commandExecutor.setCommand(registrationNumbersForCarWithColour);
                commandExecutor.update();
                break;
            case "slot_numbers_for_cars_with_colour":
                String colourOfCarInSlot = input.next();
                Command slotNumberForCarWithColour = new SlotNumberOfCarWithColour(parkingLot, colourOfCarInSlot);
                commandExecutor.setCommand(slotNumberForCarWithColour);
                commandExecutor.update();
                break;
            case "slot_number_for_registration_number":
                String registrationNumberForSlot = input.next();
                Command findSlotNumberForRegistrationNumber = new SlotNumberForRegistrationNumber(parkingLot, registrationNumberForSlot);
                commandExecutor.setCommand(findSlotNumberForRegistrationNumber);
                commandExecutor.update();
                break;
        }
    }
}
