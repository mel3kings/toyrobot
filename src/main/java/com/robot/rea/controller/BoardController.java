package com.robot.rea.controller;

import com.robot.rea.command.Command;
import com.robot.rea.command.MoveCommand;
import com.robot.rea.command.PlaceCommand;
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
        Command current = null;

        for (String command : commands) {
            if (command.equals(Robot.Command.PLACE.toString())) {
                current = new PlaceCommand();
            } else if (command.equals(Robot.Command.MOVE.toString())) {
                current = new MoveCommand(this.MAX_X_AXIS, this.MAX_Y_AXIS);
            }

            if(null != current)
            current.execute(dummy);
        }

        return dummy;
    }

}
