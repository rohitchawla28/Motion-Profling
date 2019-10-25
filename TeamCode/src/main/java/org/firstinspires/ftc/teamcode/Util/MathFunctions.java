package org.firstinspires.ftc.teamcode.Util;

public class MathFunctions {

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public static boolean inRangeOf(double value, double check, double tolerance) {
        return value > (check - tolerance) && value < (check + tolerance);
    }

    public static double yIntercept(double slope, Point point) {
        return point.getY() - (slope * point.getX());
    }

    public static double solveLinear(double slope, double x, double yIntercept) {
        return (slope * x) + yIntercept;
    }
}
