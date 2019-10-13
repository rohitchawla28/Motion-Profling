package org.firstinspires.ftc.teamcode.PathGeneration;

import java.util.ArrayList;

public class Trajectory {
    // store original points
    // store injected points - interpolate() method
    // store left/right path points - generate()
    // store left/right velocities - generate()
    // store left/right accelerations - generate()
    // store left/right velocities after modifying
    // store left/right accelerations after modifying

    ArrayList<Point> origPath;
    ArrayList<Point> injectedPath;
    ArrayList<Spline> path;
    ArrayList<Double> vel;
    ArrayList<Double> acc;

    ArrayList<Point> leftPath;
    ArrayList<Double> leftVel;
    ArrayList<Double> leftAcc;

    ArrayList<Point> rightPath;
    ArrayList<Double> rightVel;
    ArrayList<Double> rightAcc;

    public Trajectory(ArrayList<Point> originalPath) {
        this.origPath = originalPath;

        injectedPath = new ArrayList<>();
        path = new ArrayList<>();
        vel = new ArrayList<>();
        acc = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVel = new ArrayList<>();
        leftAcc = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVel = new ArrayList<>();
        rightAcc = new ArrayList<>();
        
    }

    public Trajectory() {
        origPath = new ArrayList<>();

        injectedPath = new ArrayList<>();
        path = new ArrayList<>();
        vel = new ArrayList<>();
        acc = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVel = new ArrayList<>();
        leftAcc = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVel = new ArrayList<>();
        rightAcc = new ArrayList<>();;
    }
    
    public void setOriginalPath(ArrayList<Point> originalPath) {
        this.origPath = originalPath;
    }

    public void generateSplines() {

    }
    
    
}
