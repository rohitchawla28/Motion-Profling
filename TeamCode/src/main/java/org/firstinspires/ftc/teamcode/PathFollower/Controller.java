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

    public double PDVA(double prevSError, double sError, double dt, double goalVel, double goalAcc) {
        double p = sError * kP;
        double d = (((sError - prevSError) / dt) - goalVel) * kD;
        double v = goalVel * kV;
        double a = goalAcc * kA;

        return p + d + v + a;
    }
}
