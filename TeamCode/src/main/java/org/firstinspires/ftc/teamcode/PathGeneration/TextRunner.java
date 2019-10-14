package org.firstinspires.ftc.teamcode.PathGeneration;

import android.util.Log;
import android.util.LogPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextRunner {
    public static void main(String[] args) throws IOException {
        Point start = new Point(0,0,1);
        Point end = new Point(5,2,12);

        Spline s = new Spline(start, end);
        Spline s1 = new Spline(new Point(5,2,4), new Point(5,5,5),1,5);
        Spline s2 = new Spline(new Point(5,5,5), new Point(10,-5,10),5,10);
        Spline s3 = new Spline(new Point(10,-5,10), new Point(15,8,30),10,1);

        s.generateCubicSpline();
        s1.generateCubicSpline();
        s2.generateCubicSpline();
        s3.generateCubicSpline();

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


        System.out.println(s.arcLength() + s1.arcLength());

        System.out.println(s.solveAt(.5));
        /* PrintWriter printWriter = new PrintWriter(new File("spline.txt"));
        printWriter.print(s.toString());
        printWriter.close(); */

    }
}
