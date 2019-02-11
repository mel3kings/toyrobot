package com.robot.rea.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Robot {

    private int xAxis;
    private int yAxis;
    private Direction direction;
    private boolean isInitialised = false;
    private List<Point> blockedPoints = new ArrayList<Point>();

    public List<Point> getBlockedPoints() {
        return blockedPoints;
    }

    public void setBlockedPoints(List<Point> blockedPoints) {
        this.blockedPoints = blockedPoints;
    }

    public enum Instruction {
        PLACE, MOVE, LEFT, RIGHT, REPORT, PLACE_OBJECT
    }

    public void reportLocation() {
        System.out.println(this.getxAxis() + "," + this.getyAxis() + "," + String.valueOf(direction));
    }

    public String getLocation() {
        return this.getxAxis() + "," + this.getyAxis() + "," + String.valueOf(direction);
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void move() {
        Point p = getLocationInFront();
        boolean invalid = Optional.ofNullable(blockedPoints).orElse(Collections.emptyList()).stream()
                .anyMatch(blocked -> blocked.getxAxis() == p.getxAxis() && blocked.getyAxis() == p.getyAxis());
        if (!invalid) {
            this.xAxis = p.getxAxis();
            this.yAxis = p.getyAxis();
        }
    }

    public Point getLocationInFront() {
        Point p = new Point(this.xAxis, this.yAxis);
        switch (direction) {
            case NORTH:
                p.setyAxis(yAxis + 1);
                break;
            case SOUTH:
                if (yAxis > 0) p.setyAxis(yAxis - 1);
                break;
            case EAST:
                p.setxAxis(xAxis + 1);
                break;
            case WEST:
                if (xAxis > 0) p.setxAxis(xAxis - 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid move command");
        }
        return p;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public boolean isInitialised() {
        return isInitialised;
    }

    public void setInitialised(boolean initialised) {
        isInitialised = initialised;
    }
}
