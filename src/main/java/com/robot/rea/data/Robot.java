package com.robot.rea.data;

public class Robot {
    private int xAxis;
    private int yAxis;
    private Direction direction;

    private boolean isInitialised = false;

    public boolean isInitialised() {
        return isInitialised;
    }

    public void setInitialised(boolean initialised) {
        isInitialised = initialised;
    }


    public enum Command {
        PLACE, MOVE, LEFT, RIGHT, REPORT
    }

    public Robot(int x, int y, Direction direction) {
        this.xAxis = x;
        this.yAxis = y;
        this.direction = direction;
    }

    public Robot() {

    }

    public void reportLocation() {
        System.out.println(this.getxAxis() + "," + this.getyAxis() + "," + String.valueOf(direction));
    }

    public String getLocation() {
        return this.getxAxis() + "," + this.getyAxis() + "," + String.valueOf(direction);
    }

    public void turnLeft() {
        if (isInitialised) {
            direction = direction.turnLeft();
        }
    }

    public void turnRight() {
        if (isInitialised) {
            direction = direction.turnRight();
        }
    }

    public void move() {
        System.out.print("moving from " + direction + " current axis is :" + xAxis + "," + yAxis);
        switch (direction) {
            case NORTH: yAxis += 1; break;
            case SOUTH: if(yAxis > 0) yAxis -= 1;  break;
            case EAST: xAxis += 1; break;
            case WEST: if(xAxis > 0) xAxis -= 1; break;
            default:
                throw new IllegalArgumentException("Invalid move command");
        }
        System.out.println("after moving " + direction + " current axis is :" + xAxis + "," + yAxis);
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

}
