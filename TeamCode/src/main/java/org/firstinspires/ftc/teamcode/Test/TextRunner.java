package org.firstinspires.ftc.teamcode.Test;

import org.firstinspires.ftc.teamcode.PathGeneration.Trajectory;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Util.MathFunctions;
import org.firstinspires.ftc.teamcode.Util.Point;
import org.firstinspires.ftc.teamcode.Util.Vector;

import java.io.IOException;
import java.util.ArrayList;

public class TextRunner {
    Drivetrain drivetrain;

    public static void main(String[] args) throws IOException {
        ArrayList<Point> points = new ArrayList<>();
//        points.add(new Point(50,5,-34));
//        points.add(new Point(-11,10,50));
//        points.add(new Point(10, -40, 10));
//        points.add(new Point(-30, 15, -20));
//
//        Trajectory t = new Trajectory(points);
//        t.generateSplines();
//        System.out.println(t.equationToString());
//        t.injectPoints(2, 1);
//        System.out.println(t.injectedPointsToString());

        Trajectory t = new Trajectory(points);
        System.out.println(t.getLeftPos(1, 4, Math.PI / 6, 18));
        System.out.println(t.getRightPos(1, 4, Math.PI / 6, 18));

    }


}
