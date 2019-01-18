package com.robot.rea;

import com.robot.rea.data.Robot;
import com.robot.rea.controller.BoardController;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BoardControllerTest {

    @Test
    public void testInitializeBoard() {
        BoardController br = new BoardController(5, 5);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        Robot r = br.executeCommands(commands);
        assertEquals(r.getLocation(), "0,0,NORTH");
    }

    @Test
    public void testSimpleCommandShouldMoveOneStep() {
        BoardController br = new BoardController(5, 5);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("MOVE");
        Robot r = br.executeCommands(commands);
        assertEquals(r.getLocation(), "0,1,NORTH");
    }

    @Test
    public void testExceedBoardShouldDisregard() {
        BoardController br = new BoardController(2, 2);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        Robot r = br.executeCommands(commands);
        assertEquals(r.getLocation(), "0,2,NORTH");

    }
}
