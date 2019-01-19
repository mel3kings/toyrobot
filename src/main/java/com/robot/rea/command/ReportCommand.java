package com.robot.rea.command;

import com.robot.rea.data.Robot;

/**
 * Report robot location
 */
public class ReportCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isInitialised()) {
            robot.reportLocation();
        }
    }
}
