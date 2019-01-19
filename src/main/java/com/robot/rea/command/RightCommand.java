package com.robot.rea.command;

import com.robot.rea.data.Robot;

public class RightCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isInitialised()) {
            robot.turnRight();
        }
    }
}
