package org.firstinspires.ftc.teamcode.Util;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;

public class MathFunctions {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public static boolean inRangeOf(double value, double check, double tolerance) {
        return value > (check - tolerance) && value < (check + tolerance);
    }
}
