package com.robot.rea.command;

import com.robot.rea.data.Robot;

public class MoveCommand implements Command {

    private int MAX_X_AXIS;
    private int MAX_Y_AXIS;

    public MoveCommand(int x, int y) {
        this.MAX_X_AXIS = x;
        this.MAX_Y_AXIS = y;

    }

    @Override
    public void execute(Robot robot) {
        if (robot.getxAxis() < MAX_X_AXIS && robot.getxAxis() >= 0
                && robot.getyAxis() < MAX_Y_AXIS && robot.getyAxis() >= 0) {
            robot.move();
        }
    }
}
