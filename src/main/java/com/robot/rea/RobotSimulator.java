package com.robot.rea;

import com.robot.rea.controller.BoardController;
import com.robot.rea.input.ConsoleReader;
import com.robot.rea.input.InputReader;

import java.util.List;

public class RobotSimulator {

    public static void main(String[] args) {
        InputReader input = new ConsoleReader();
        BoardController board = new BoardController(5, 5);
        List<String> commands = input.getCommandsFromUser("/INPUT1.txt");
        board.executeCommands(commands);
    }
}
