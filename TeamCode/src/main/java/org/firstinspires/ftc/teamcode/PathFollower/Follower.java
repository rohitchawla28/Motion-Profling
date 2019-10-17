package org.firstinspires.ftc.teamcode.PathFollower;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;
import org.firstinspires.ftc.teamcode.PathGeneration.Trajectory;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Util.MathFunctions;

import java.util.ArrayList;

public class Follower {

    private Drivetrain drivetrain;
    private Controller controller;
    private Trajectory trajectory;

    private LinearOpMode opMode;

    // iterate through points to follow velocities
    // assuming equal dt steps
    public void followTrajectory() throws InterruptedException{

        Drivetrain drivetrain = new Drivetrain(opMode);

        double leftSError;
        double rightSError;

        Point leftCurrPoint = trajectory.leftPath.get(0);
        Point leftNextPoint = trajectory.leftPath.get(1);
        double prevLeftSError = MathFunctions.distance(leftCurrPoint, leftNextPoint);

        Point rightCurrPoint = trajectory.rightPath.get(0);
        Point rightNextPoint = trajectory.rightPath.get(1);
        double prevRightSError = MathFunctions.distance(rightCurrPoint, rightNextPoint);

        // TODO: change method for current inches?
        int len = trajectory.leftVel.size();
        for (int i = 0; i < len; i++) {
            leftCurrPoint = trajectory.leftPath.get(i);
            leftNextPoint = trajectory.leftPath.get(i + 1);
            // TODO: fix for negative error
            leftSError = MathFunctions.distance(leftCurrPoint, leftNextPoint);

            double leftGoalVel = trajectory.leftVel.get(i);
            double leftGoalAcc = trajectory.leftAcc.get(i);

            rightCurrPoint = trajectory.rightPath.get(i);
            rightNextPoint = trajectory.rightPath.get(i + 1);
            rightSError = MathFunctions.distance(rightCurrPoint, rightNextPoint);

            double rightGoalVel = trajectory.rightVel.get(i);
            double rightGoalAcc = trajectory.rightAcc.get(i);

            double leftPower = controller.PDVA(leftSError, prevLeftSError, trajectory.dt, leftGoalVel, leftGoalAcc);
            double rightPower = controller.PDVA(rightSError, prevRightSError, trajectory.dt, rightGoalVel, rightGoalAcc);

            drivetrain.setLeftPower(leftPower);
            drivetrain.setRightPower(rightPower);

            prevLeftSError = leftSError;
            prevRightSError = rightSError;
        }

        drivetrain.stopMotors();
    }


}
