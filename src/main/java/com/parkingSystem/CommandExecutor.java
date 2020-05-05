package com.parkingSystem;

import com.parkingSystem.commands.Command;

class CommandExecutor {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void update() {
        command.execute();
    }
}
