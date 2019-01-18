package com.robot.rea.command;

import com.robot.rea.data.Direction;
import com.robot.rea.data.Robot;

public class PlaceCommand implements Command {

    @Override
    public void execute(Robot robot) {
        robot.setDirection(Direction.NORTH);
        robot.setInitialised(true);
    }
}
