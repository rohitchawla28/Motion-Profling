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

    public double pdvaOutput(Point currPoint, Point nextPoint, double dt, double prevError, double curr_V, double goal_v, double goal_a) {
        double s_error = MathFunctions.distance(currPoint, nextPoint);
        double v_error = goal_v - curr_V;

        double p = s_error * kP;
        double d = ((s_error - prevError) / (dt - goal_v)) * kD;
        double v = goal_v * kV;
        double a = goal_a * kA;

        return p + d + v + a;
    }
}
