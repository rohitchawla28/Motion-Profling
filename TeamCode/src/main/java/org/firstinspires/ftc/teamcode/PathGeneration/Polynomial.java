package org.firstinspires.ftc.teamcode.PathGeneration;

import java.util.ArrayList;

public class Polynomial {

    Point start;
    Point end;

    ArrayList<Double> coefficients;

    public Polynomial() {
        start = new Point();
        end = new Point();
        coefficients = new ArrayList<>();
    }

    public Polynomial(Point start, Point end) {
        this.start = start;
        this.end = end;
        coefficients = new ArrayList<>();
    }

    public ArrayList<Double> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(ArrayList<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double solve(Double t) {

        double solution = 0.0;

        for (int i = 0; i < coefficients.size(); i++) {
            double coefficient = coefficients.get(i);
            solution += coefficient * Math.pow(t, i);
        }

        return solution;
    }

    public String toString() {

        String t = "";

        for (int i = 0; i < coefficients.size(); i++) {
            if (i == coefficients.size() - 1)
                t += coefficients.get(i) + "t^" + i;
            else
                t += coefficients.get(i) + "t^" + i + " + ";
        }
        return t; //+ "{" + Math.min(start.getX(), end.getX()) + "<x<" + Math.max(start.getX(), end.getX()) + "}";
    }
}
