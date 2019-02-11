package com.robot.rea.command;

import com.robot.rea.data.Robot;

/**
 * Move robot whichever it is facing iff the robot is initialised
 * we are taking in params as the max x and y axis, so the robot does not fall off
 */
public class MoveCommand implements Command {

    private int MAX_X_AXIS;
    private int MAX_Y_AXIS;

    public MoveCommand(int x, int y) {
        this.MAX_X_AXIS = x;
        this.MAX_Y_AXIS = y;
    }

    @Override
    public void execute(Robot robot) {
        if (robot.isInitialised() && robot.getxAxis() < MAX_X_AXIS && robot.getxAxis() >= 0
                && robot.getyAxis() < MAX_Y_AXIS && robot.getyAxis() >= 0) {
            robot.move();
        }
    }
}
