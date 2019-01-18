package com.robot.rea.command;

import com.robot.rea.data.Direction;
import com.robot.rea.data.Robot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceCommand implements Command {

    private static final Pattern PLACE_REGEX = Pattern.compile("PLACE (\\d+),(\\d+),(\\w+)");
    private int xCoordinates;
    private int yCoordinates;
    private Direction direction;
    private boolean valid = false;

    public PlaceCommand(int x, int y, Direction direction) {
        this.xCoordinates = x;
        this.yCoordinates = y;
        this.direction = direction;
    }

    public PlaceCommand(String requestString) {
        try {
            String[] request = parseCommand(requestString);
            xCoordinates = Integer.parseInt(request[0]);
            yCoordinates = Integer.parseInt(request[1]);
            direction = Direction.valueOf(request[2]);
            valid = true;
        } catch (Exception ex) {
            System.out.println("invalid place command");
        }
    }

    @Override
    public void execute(Robot robot) {
        if (valid) {
            robot.setxAxis(xCoordinates);
            robot.setyAxis(yCoordinates);
            robot.setDirection(direction);
            robot.setInitialised(true);
        }
    }

    private String[] parseCommand(String command) {
        Matcher matcher = PLACE_REGEX.matcher(command);
        String[] result = new String[3];
        if (matcher.matches()) {
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
            result[2] = matcher.group(3);
        }
        return result;
    }

    public boolean isValid() {
        return valid;
    }
}
