package org.firstinspires.ftc.teamcode.PathFollower;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Util.MathFunctions;

public class Controller {
    private Drivetrain drivetrain;

    // TODO: how to tune constants
    private double kP;
    private double kD;
    private double kV;
    private double kA;

    public double PDVA(Point currPoint, Point nextPoint, double dt, double prevSError, double goalVel, double goalAcc) {
        double sError = MathFunctions.distance(currPoint, nextPoint);

        double p = sError * kP;
        double d = ((sError - prevSError) / (dt - goalVel)) * kD;
        double v = goalVel * kV;
        double a = goalAcc * kA;

        return p + d + v + a;
    }
}
