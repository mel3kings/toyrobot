package com.robot.rea;

import com.robot.rea.controller.BoardController;
import com.robot.rea.input.ConsoleReader;
import com.robot.rea.input.InputReader;

import java.util.List;

/**
 * Main Application for Toy Robot Simulator
 */
public class RobotSimulator {

    public static void main(String[] args) {
        BoardController board = new BoardController(5, 5);
        InputReader input = new ConsoleReader();
        List<String> commands = input.getCommandsFromUser("");
        board.executeCommands(commands);
    }
}
