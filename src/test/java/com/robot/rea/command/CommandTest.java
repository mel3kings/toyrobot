package com.robot.rea.command;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CommandTest {

    @Test
    public void testInvalidPlaceCommand() {
        PlaceCommand p = new PlaceCommand("11234");
        assertFalse(p.isValid());
    }

    @Test
    public void testValidPlaceCommand(){
        PlaceCommand p = new PlaceCommand("0,0,NORTH");
        assertFalse(p.isValid());
    }
}
