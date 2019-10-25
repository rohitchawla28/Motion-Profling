package org.firstinspires.ftc.teamcode.Util;

public class Point {
    private double x;
    private double y;
    private double theta;

    // TODO: change to heading instead of theta and do inverse tan?
    public Point(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        x = 0;
        y = 0;
        theta = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public boolean equals(Object point) {
        Point other = (Point) point;
        return this.x == other.x && this.y == other.y && this.theta == other.theta;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
