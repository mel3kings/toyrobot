package com.robot.rea.controller;

import com.robot.rea.data.Robot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BoardControllerTest {
    private BoardController br = null;
    private ArrayList<String> commands;

    @Before
    public void init() {
        br = new BoardController(5, 5);
        commands = new ArrayList<>();
    }

    @Test
    public void testInitializeBoard() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,0,NORTH", r.getLocation());
    }

    @Test
    public void testSimpleCommandShouldMoveOneStep() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,1,NORTH", r.getLocation());
    }

    @Test
    public void testExceedBoardShouldDisregard() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,5,NORTH", r.getLocation());
    }

    @Test
    public void testExceedRightBoardShouldDisregard() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("RIGHT");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("5,0,EAST", r.getLocation());
    }

    @Test
    public void testRightMovement() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");
        commands.add("RIGHT");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("1,1,EAST", r.getLocation());
    }

    @Test
    public void testLeftMovement() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");
        commands.add("LEFT");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,1,WEST", r.getLocation());
    }

    @Test
    public void testNoMovement() {
        commands.add("PLACE 0,0,NORTH");
        commands.add("LEFT");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,0,WEST", r.getLocation());
    }

    @Test
    public void testMiddleOfTheBoardMovement() {
        commands.add("PLACE 1,2,EAST");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("LEFT");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("3,3,NORTH", r.getLocation());
    }

    @Test
    public void testInvalidCommands() {
        commands.add("PLACE 1,2,EAST");
        commands.add("BLAH");
        commands.add("ADADADAS");
        commands.add("");
        commands.add(null);
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("2,2,EAST", r.getLocation());
    }

    @Test
    public void testNewPlaceObjectCommand() {
        commands.add("PLACE 0,0,EAST");
        commands.add("PLACE_OBJECT");
        commands.add("MOVE");
        commands.add("REPORT");
        Robot r = br.executeCommands(commands);
        assertEquals("0,0,EAST", r.getLocation());
    }
}
