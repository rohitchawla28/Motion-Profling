package org.firstinspires.ftc.teamcode.PathGeneration;

import java.util.ArrayList;

public class PointAllData {
    private double x;
    private double y;
    private double theta;
    private double goalVel;
    private double goalAcc;

    public PointAllData(double x, double y, double theta, double goalVel, double goalAcc) {
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.goalVel = goalVel;
        this.goalAcc = goalAcc;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public double getGoalVel() {
        return goalVel;
    }

    public double getGoalAcc() {
        return goalAcc;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + theta + ", " + goalVel + ", " + goalAcc;
    }

    public ArrayList<Double> toArrayList() {
        ArrayList<Double> pointAllData = new ArrayList<>();
        pointAllData.add(x);
        pointAllData.add(y);
        pointAllData.add(theta);
        pointAllData.add(goalVel);
        pointAllData.add(goalAcc);

        return  pointAllData;
    }

}
