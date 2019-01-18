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
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void move() {
        switch (direction) {
            case NORTH:
                yAxis += 1;
                break;
            case SOUTH:
                yAxis += 1;
                break;
            case EAST:
                xAxis -= 1;
                break;
            case WEST:
                xAxis -= 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid move command");
        }
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
