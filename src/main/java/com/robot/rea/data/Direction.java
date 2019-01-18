package com.robot.rea.data;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction turnLeft() {
        switch (this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: throw new IllegalArgumentException("Invalid Turn Left Direction");
        }
    }

    public Direction turnRight() {
        switch (this) {
            case NORTH: return EAST;
            case WEST: return NORTH;
            case SOUTH: return WEST;
            case EAST: return SOUTH;
            default:  throw new IllegalArgumentException("Invalid Turn Right Direction");
        }
    }
}
