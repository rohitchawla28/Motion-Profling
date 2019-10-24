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
        points.add(new Point(1,1, 43));
        points.add(new Point(85, 20, 962));
        points.add(new Point(-16, 78, 32));
        points.add(new Point(52, 7, 52));

        Trajectory t = new Trajectory(points);
        t.generateSplines();
        System.out.println(t.equationToString());
        t.injectPoints(2, 1);
        System.out.println(t.injectedPointsToString());

//        System.out.println(TestMethods.getLeftPos(1, 4, Math.PI / 4, 18));
//        System.out.println(TestMethods.getRightPos(1, 4, Math.PI / 4, 18));

    }


}
