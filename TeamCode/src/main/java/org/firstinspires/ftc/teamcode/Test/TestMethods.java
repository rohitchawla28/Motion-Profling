package org.firstinspires.ftc.teamcode.Test;

import org.firstinspires.ftc.teamcode.Util.MathFunctions;
import org.firstinspires.ftc.teamcode.Util.Point;
import org.firstinspires.ftc.teamcode.Util.Vector;

public class TestMethods {
    public static Point getLeftPos(double x, double y, double yaw, double width) {
        System.out.println("(" + x + ", " + y + ")");

        if (yaw == 0) {
            return new Point(x, y + (width / 2));
        }
        else if (yaw == Math.PI) {
            return new Point(x, y - (width / 2));
        }
        else if (yaw == (Math.PI / 2)) {
            return new Point(x - (width / 2), y);
        }
        else if (yaw == ((3 * Math.PI) / 2)) {
            return new Point(x + (width / 2), y);
        }

        double theta = Math.tan(yaw);
        double yInt = MathFunctions.yIntercept(theta, new Point(x, y));

        System.out.println("y = " + theta + "x + " + yInt);

        double perpendicular = -1 * (1 / theta);
        double perpYInt = MathFunctions.yIntercept(perpendicular, new Point(x, y));

        System.out.println("y = " + perpendicular + "x + " + perpYInt);

        Vector vector = new Vector(x, y, x + 1, MathFunctions.solveLinear(perpendicular, x + 1, perpYInt));

        if (yaw < Math.PI / 2 || yaw > (3 * Math.PI) / 2) {
            return new Point(x - ((width / 2) * vector.getUnitV1()), y - ((width / 2) * vector.getUnitV2()));
        }
        else {
            System.out.println("Different left trans");
            return new Point(x + ((width / 2) * vector.getUnitV1()), y + ((width / 2) * vector.getUnitV2()));
        }

    }

    public static Point getRightPos(double x, double y, double yaw, double width) {
        System.out.println("(" + x + ", " + y + ")");
        if (yaw == 0) {
            return new Point(x, y - (width / 2));
        }
        else if (yaw == Math.PI) {
            return new Point(x, y + (width / 2));
        }
        else if (yaw == (Math.PI / 2)) {
            return new Point(x + (width / 2), y);
        }
        else if (yaw == ((3 * Math.PI) / 2)) {
            return new Point(x - (width / 2), y);
        }

        double theta = Math.tan(yaw);
        double yInt = MathFunctions.yIntercept(theta, new Point(x, y));

        System.out.println("y = " + theta + "x + " + yInt);

        double perpendicular = -1 * (1 / theta);
        double perpYInt = MathFunctions.yIntercept(perpendicular, new Point(x, y));

        System.out.println("y = " + perpendicular + "x + " + perpYInt);

        Vector vector = new Vector(x, y, x + 1, MathFunctions.solveLinear(perpendicular, x + 1, perpYInt));

        if (yaw < Math.PI / 2 || yaw > (3 * Math.PI) / 2) {
            return new Point(x + ((width / 2) * vector.getUnitV1()), y + ((width / 2) * vector.getUnitV2()));
        }
        else {
            System.out.println("Different right trans");
            return new Point(x - ((width / 2) * vector.getUnitV1()), y - ((width / 2) * vector.getUnitV2()));
        }
    }
}
