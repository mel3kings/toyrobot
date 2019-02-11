package com.robot.rea.command;

import com.robot.rea.data.Point;
import com.robot.rea.data.Robot;

public class PlaceObjectCommand implements Command {
    @Override
    public void execute(Robot robot) {
        if (robot.isInitialised()) {
            Point blockedObject = robot.getLocationInFront();
            robot.getBlockedPoints().add(blockedObject);
        }
    }
}
