package com.robot.rea.command;

import com.robot.rea.data.Robot;

/**
 * We are using Command Design Pattern,
 * any new command needs to implement this interface
 */
public interface Command {

    void execute(Robot robot);
}
