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
        points.add(new Point(-1,12.5,15));
        points.add(new Point(20,2,50));
        points.add(new Point(-15,30,-20));
        points.add(new Point(0,.5,50));
        points.add(new Point(-16,.5,1.0));

        Trajectory t = new Trajectory(points);
        t.generateSplines();
        //t.injectPoints(0.05, 0.01);
        System.out.println(t);


        /* PrintWriter printWriter = new PrintWriter(new File("spline.txt"));
        printWriter.print(s.toString());
        printWriter.close(); */

    }
}
