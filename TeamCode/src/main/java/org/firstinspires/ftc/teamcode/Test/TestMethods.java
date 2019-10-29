package org.firstinspires.ftc.teamcode.Test;

import org.firstinspires.ftc.teamcode.Util.MathFunctions;
import org.firstinspires.ftc.teamcode.Util.Point;
import org.firstinspires.ftc.teamcode.Util.Constants;

public class TestMethods {

    public static Point getLeftPos(double x, double y, double yaw, double width) {

        double a = x - Constants.kWidth/2.0 * Math.cos(yaw - Math.PI/2);
        double b = y - Constants.kWidth/2.0 * Math.sin(yaw - Math.PI/2);

        return new Point(a, b);

    }

    public static Point getRightPos(double x, double y, double yaw, double width) {

        double a = x + Constants.kWidth/2.0 * Math.cos(yaw - Math.PI/2);
        double b = y + Constants.kWidth/2.0 * Math.sin(yaw - Math.PI/2);

        return new Point(a, b);
    }

}
