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
        assertEquals( "0,0,NORTH",r.getLocation());
    }

    @Test
    public void testSimpleCommandShouldMoveOneStep() {
        BoardController br = new BoardController(5, 5);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("MOVE");
        Robot r = br.executeCommands(commands);
        assertEquals( "0,1,NORTH",r.getLocation());
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
        assertEquals("0,2,NORTH",r.getLocation());

    }

    @Test
    public void testRightMovement() {
        BoardController br = new BoardController(2, 2);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("MOVE");
        commands.add("RIGHT");
        commands.add("MOVE");
        Robot r = br.executeCommands(commands);
        assertEquals( "1,1,EAST",r.getLocation());
    }

    @Test
    public void testLeftMovement() {
        BoardController br = new BoardController(2, 2);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("MOVE");
        commands.add("LEFT");
        commands.add("MOVE");
        Robot r = br.executeCommands(commands);
        assertEquals("0,1,WEST",r.getLocation());
    }

    @Test
    public void testNoMovement(){
        BoardController br = new BoardController(2, 2);
        ArrayList<String> commands = new ArrayList<>();

        commands.add("PLACE");
        commands.add("LEFT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,0,WEST",r.getLocation());
    }

}
