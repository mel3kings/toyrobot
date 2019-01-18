package com.robot.rea.command;

import com.robot.rea.data.Robot;

public class ReportCommand implements Command {


    @Override
    public void execute(Robot robot) {
        robot.reportLocation();
    }
}
