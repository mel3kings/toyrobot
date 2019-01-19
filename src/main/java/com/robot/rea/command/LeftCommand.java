package com.robot.rea.command;

import com.robot.rea.data.Robot;

public class LeftCommand implements Command {
    @Override
    public void execute(Robot robot) {
        if (robot.isInitialised()) {
            robot.turnLeft();
        }
    }
}
