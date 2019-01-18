package com.robot.rea.controller;

import com.robot.rea.command.*;
import com.robot.rea.data.Robot;

import java.util.List;

public class BoardController {

    private int MAX_X_AXIS;
    private int MAX_Y_AXIS;


    public BoardController(int x, int y) {
        this.MAX_X_AXIS = x;
        this.MAX_Y_AXIS = y;
    }

    public Robot executeCommands(List<String> commands) {
        Robot dummy = new Robot();
        Command command = null;

        for (String strCommand : commands) {
            if (strCommand.equals(Robot.Command.PLACE.toString())) {
                command = new PlaceCommand();
            } else if (strCommand.equals(Robot.Command.MOVE.toString())) {
                command = new MoveCommand(this.MAX_X_AXIS, this.MAX_Y_AXIS);
            } else if (strCommand.equals(Robot.Command.LEFT.toString())) {
                command = new LeftCommand();
            } else if (strCommand.equals(Robot.Command.RIGHT.toString())) {
                command = new RightCommand();
            }
            if (null != command){
                command.execute(dummy);
            }
        }
        return dummy;
    }

}
