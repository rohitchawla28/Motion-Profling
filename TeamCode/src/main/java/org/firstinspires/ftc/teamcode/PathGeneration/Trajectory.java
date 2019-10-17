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

    public ArrayList<Point> pointsPath;
    public ArrayList<Point> injectedPath;

    public ArrayList<Spline> splinesPath;

    public ArrayList<Double> vel;
    public ArrayList<Double> acc;

    public ArrayList<Point> leftPath;
    public ArrayList<Double> leftVel;
    public ArrayList<Double> leftAcc;

    public ArrayList<Point> rightPath;
    public ArrayList<Double> rightVel;
    public ArrayList<Double> rightAcc;

    public double dt;

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

    public void setDt(double dt) {
        this.dt = dt;
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
    // TODO:
    public void injectPoints(double spacing, double tolerance) {
        HashMap<Double, Point> points = new HashMap<>();

        double t = 0;
        double tStep = 0.0001;
        double prevDistance = 0;
        double currDistance;
        double tempDistance;

        boolean correctSpacing;

        Point prevPoint = splinesPath.get(0).solveAt(0);
        Point tempPoint;
        Point currPoint;

        for (Spline spline : splinesPath) {
            while (t <= 1) {
                currPoint = spline.solveAt(t + tStep);
                currDistance = MathFunctions.distance(currPoint, prevPoint);
                correctSpacing = MathFunctions.inRangeOf(currDistance, spacing, tolerance);
                while (!correctSpacing) {
                    tStep += 0.0001;

                    prevDistance += currDistance;
                    currPoint = spline.solveAt(t + tStep);
                    currDistance = MathFunctions.distance(currPoint, prevPoint);
                    correctSpacing = MathFunctions.inRangeOf(currDistance + prevDistance, spacing, tolerance);
                }
                points.put(t + tStep, currPoint);

                prevPoint = currPoint;
                t += tStep;
                tStep = 0.0001;
                prevDistance = 0;
            }
            t = 0;
        }
        injectedPath = UtilFunctions.hashMapToArrayList(points);

    }
    
    public String toString() {
        String t = "";
        for (Spline spline : splinesPath)
            t += spline + "\n";
        return t;
    }
}
