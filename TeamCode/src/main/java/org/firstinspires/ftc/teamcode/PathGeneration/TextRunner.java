package org.firstinspires.ftc.teamcode.PathGeneration;

import android.util.Log;
import android.util.LogPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextRunner {
    public static void main(String[] args) throws IOException {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(50,5,15));
        points.add(new Point(-11,10,50));

        Trajectory t = new Trajectory(points);
        t.generateSplines();
        System.out.println(t.equationToString());
        t.injectPoints(6, 0.1);
        System.out.println(t.injectedPointsToString());

    }
}
