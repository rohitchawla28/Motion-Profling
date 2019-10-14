package org.firstinspires.ftc.teamcode.PathGeneration;

public class Point {
    private double x;
    private double y;
    private double theta;

    // TODO: change to pose? or pose and point separate?
    public Point(double xCoord, double yCoord, double theta) {
        this.x = xCoord;
        this.y = yCoord;
        this.theta = theta;
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

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public boolean equals(Object point) {
        Point other = (Point) point;
        return this.x == other.x && this.y == other.y && this.theta == other.theta;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
