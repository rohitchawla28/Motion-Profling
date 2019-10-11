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



}
