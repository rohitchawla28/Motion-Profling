package org.firstinspires.ftc.teamcode.PathGeneration;

public class Point {
    private double x;
    private double y;

    public Point(double xCoord, double yCoord) {
        this.x = xCoord;
        this.y = yCoord;
    }

    public Point() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equals(Object point) {
        Point other = (Point) point;
        return this.x == other.x && this.y == other.y;
    }

}
