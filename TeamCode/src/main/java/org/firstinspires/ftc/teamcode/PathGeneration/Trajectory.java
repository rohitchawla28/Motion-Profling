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

    ArrayList<Point> originalPath;
    ArrayList<Point> injectedPath;
    ArrayList<Spline> path;
    ArrayList<Double> velocity;
    ArrayList<Double> accel;

    ArrayList<Point> leftPath;
    ArrayList<Double> leftVelocity;
    ArrayList<Double> leftAccel;

    ArrayList<Point> rightPath;
    ArrayList<Double> rightVelocity;
    ArrayList<Double> rightAccel;

    public Trajectory(ArrayList<Point> originalPath) {
        this.originalPath = originalPath;

        injectedPath = new ArrayList<>();
        path = new ArrayList<>();
        velocity = new ArrayList<>();
        accel = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVelocity = new ArrayList<>();
        leftAccel = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVelocity = new ArrayList<>();
        rightAccel = new ArrayList<>();
        
    }

    public Trajectory() { 
        
        originalPath = new ArrayList<>();
        injectedPath = new ArrayList<>();
        path = new ArrayList<>();
        velocity = new ArrayList<>();
        accel = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVelocity = new ArrayList<>();
        leftAccel = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVelocity = new ArrayList<>();
        rightAccel = new ArrayList<>();;

        injectedPath = new ArrayList<>();
        path = new ArrayList<>();
        velocity = new ArrayList<>();
        accel = new ArrayList<>();

        leftPath = new ArrayList<>();
        leftVelocity = new ArrayList<>();
        leftAccel = new ArrayList<>();

        rightPath = new ArrayList<>();
        rightVelocity = new ArrayList<>();
        rightAccel = new ArrayList<>();
    }
    
    public void setOriginalPath(ArrayList<Point> originalPath) {
        this.originalPath = originalPath;
    }

    public void generateSplines() {

    }
    
    
}
