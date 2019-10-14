package org.firstinspires.ftc.teamcode.PathGeneration;

import java.util.ArrayList;

public class Spline {

    // start, end points
    // start and end Vel. and Acc.
    // ArrayLists for X/Y coeff of polynomial
    // ArrayList for Parameterized polynomial
    // get() and set()
    // solve(t = )
    // differentiate()
    // generate() method that parameterizes X/Y

    private Polynomial xFunction;
    private Polynomial yFunction;

    private Point start;
    private Point end;

    private double sAccel;
    private double eAccel;

    public Spline(Point start, Point end, double sAccel, double eAccel) {
        this.start = start;
        this.end = end;
        this.sAccel = sAccel;
        this.eAccel = eAccel;
        xFunction = new Polynomial();
        yFunction = new Polynomial();
    }

    public Spline(Point start, Point end) {
        this.start = start;
        this.end = end;

        sAccel = 0.0;
        eAccel = 0.0;

        xFunction = new Polynomial();
        yFunction = new Polynomial();
    }

    public void generateCubicSpline() {
        ArrayList<Double> xC = new ArrayList<>();
        ArrayList<Double> yC = new ArrayList<>();

        xFunction.setStart(new Point(0.0, start.getX(), start.getTheta()));
        xFunction.setEnd(new Point(1.0, end.getX(), end.getTheta()));
        yFunction.setStart(new Point(0.0, start.getY(), start.getTheta()));
        yFunction.setEnd(new Point(1.0, end.getY(), end.getTheta()));

        xC.add(start.getX());
        xC.add(start.getTheta());
        xC.add(-3*start.getX() + 3*end.getX() + -2*start.getTheta() + -1*end.getTheta());
        xC.add(2*start.getX() + -2*end.getX() + start.getTheta() + end.getTheta());

        xFunction.setCoefficients(xC);

        yC.add(start.getY());
        yC.add(start.getTheta());
        yC.add(-3*start.getY() + 3*end.getY() + -2*start.getTheta() + -1*end.getTheta());
        yC.add(2*start.getY() + -2*end.getY() + start.getTheta() + end.getTheta());

        yFunction.setCoefficients(yC);
    }

    // TODO: call separate functions for x/y and make method to return arrayList?
    public void generateQuinticSpline() {
        ArrayList<Double> xCoefficients = new ArrayList<>();
        ArrayList<Double> yCoefficients = new ArrayList<>();

        xFunction.setStart(new Point(0, start.getX(), start.getTheta()));
        xFunction.setEnd(new Point(1, end.getX(), end.getTheta()));
        yFunction.setStart(new Point(0, start.getY(), start.getTheta()));
        yFunction.setEnd(new Point(1, end.getY(), end.getTheta()));



    }

    public String toString() {
        return "(" + xFunction.toString() + ", " + yFunction.toString() + ")" + "\n" + start + "\n" + end;
    }


    public Point solveAt(double t) {
        return new Point(xFunction.solve(t) , yFunction.solve(t), 0);
    }

    public double arcLength() {
        double deltaX = 1/100;
        double x_i;
        double sum = 0;

        for(int i = 0; i < 100; i++){
            x_i = start.getX() + i * deltaX;
            sum += deltaX * solveAt(x_i).getY();
        }
        return sum;
    }

}
