package com.robot.rea.controller;

import com.robot.rea.command.*;
import com.robot.rea.data.Robot;

import java.util.List;

import static com.robot.rea.data.Robot.Instruction;


/**
 * Controller for executing list of commands
 */
public class BoardController {
    private int MAX_X_AXIS;
    private int MAX_Y_AXIS;

    public BoardController(int x, int y) {
        this.MAX_X_AXIS = x;
        this.MAX_Y_AXIS = y;
    }

    public Robot executeCommands(List<String> commands) {
        Robot robot = new Robot();
        if (null == commands) {
            return robot;
        }
        for (String strCommand : commands) {
            if (strCommand == null) {
                continue;
            }
            Command command = null;
            if(strCommand.equals(Instruction.PLACE_OBJECT.toString())){
                command = new PlaceObjectCommand();
            }else if (strCommand.contains(Robot.Instruction.PLACE.toString())) {
                command = new PlaceCommand(strCommand);
            } else if (strCommand.equals(Instruction.MOVE.toString())) {
                command = new MoveCommand(this.MAX_X_AXIS, this.MAX_Y_AXIS);
            } else if (strCommand.equals(Instruction.LEFT.toString())) {
                command = new LeftCommand();
            } else if (strCommand.equals(Instruction.RIGHT.toString())) {
                command = new RightCommand();
            } else if (strCommand.equals(Instruction.REPORT.toString())) {
                command = new ReportCommand();
            }
            if (null != command) {
                command.execute(robot);
            }
        }
        return robot;
    }
}


