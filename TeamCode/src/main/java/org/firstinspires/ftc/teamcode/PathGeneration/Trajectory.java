package org.firstinspires.ftc.teamcode.PathGeneration;

import org.firstinspires.ftc.teamcode.Util.MathFunctions;
import org.firstinspires.ftc.teamcode.Util.UtilFunctions;

import java.util.ArrayList;
import java.util.HashMap;

public class Trajectory {
    // store original points
    // store injected points - interpolate() method
    // store left/right path points - generate()
    // store left/right velocities - generate()
    // store left/right accelerations - generate()
    // store left/right velocities after modifying
    // store left/right accelerations after modifying

    private ArrayList<Point> pointsPath;
    private ArrayList<Point> injectedPath;

    private ArrayList<Spline> splinesPath;

    private ArrayList<Double> vel;
    private ArrayList<Double> acc;

    private ArrayList<Point> leftPath;
    private ArrayList<Double> leftVel;
    private ArrayList<Double> leftAcc;

    private ArrayList<Point> rightPath;
    private ArrayList<Double> rightVel;
    private ArrayList<Double> rightAcc;

    public Trajectory(ArrayList<Point> originalPath) {
        this.pointsPath = originalPath;

        injectedPath = new ArrayList<>();
        splinesPath = new ArrayList<>();
        vel = new ArrayList<>();
        acc = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVel = new ArrayList<>();
        leftAcc = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVel = new ArrayList<>();
        rightAcc = new ArrayList<>();
        
    }
    
    public void setOriginalPath(ArrayList<Point> originalPath) {
        this.pointsPath = originalPath;
    }

    public void generateSplines() {
        for(int i = 0; i < pointsPath.size() - 1; i++) {
            Point p1 = pointsPath.get(i);
            Point p2 = pointsPath.get(i+1);

            Spline spline = new Spline(p1,p2);
            spline.generateCubicSpline();
            splinesPath.add(spline);
        }
    }

    // inefficient
    // spacing in inches
    public void injectPoints1(double spacing, double tolerance) {
        HashMap<Double, Point> points = new HashMap<Double, Point>();

        double t = 0;
        double tStep = 0.0001;
        double distance;
        boolean correctSpacing;

        Point prevPoint = splinesPath.get(0).solveAt(0);
        Point currPoint = splinesPath.get(0).solveAt(t + tStep);

        for (Spline spline : splinesPath) {
            while (!currPoint.equals(spline.getEnd())) {
                currPoint = spline.solveAt(t + tStep);
                distance = MathFunctions.distance(currPoint, prevPoint);
                correctSpacing = MathFunctions.inRangeOf(distance, spacing, tolerance);
                while (!correctSpacing) {
                    if (distance < (spacing - tolerance)) {
                        tStep += 0.0001;
                    } else {
                        tStep -= 0.0001;
                    }
                    currPoint = spline.solveAt(t + tStep);
                    distance = MathFunctions.distance(currPoint, prevPoint);
                    correctSpacing = MathFunctions.inRangeOf(distance, spacing, tolerance);
                }
                points.put(t + tStep, currPoint);

                prevPoint = currPoint;
                t += tStep;
                tStep = 0.0001;
            }
        }
        injectedPath = UtilFunctions.hashMapToArrayList(points);

    }

    // recursive
    public void injectPoints2(double spacing) {

    }
    
    public String toString() {
        String t = "";
        for (Spline spline : splinesPath)
            t += spline + "\n";
        return t;
    }
}
