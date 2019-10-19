package org.firstinspires.ftc.teamcode.PathFollower;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

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
    // TODO: change to CSV pulling
    public void followTrajectory() throws InterruptedException{
        Drivetrain drivetrain = new Drivetrain(opMode);
        ElapsedTime time = new ElapsedTime();

        double prevTime = 0;
        double dt;

        Point leftPoint = trajectory.leftPath.get(0);
        double leftSError;
        double prevLeftSError = MathFunctions.distance(drivetrain.getLeftPos(), leftPoint);

        Point rightPoint = trajectory.rightPath.get(0);
        double rightSError;
        double prevRightSError = MathFunctions.distance(drivetrain.getRightPos(), rightPoint);

        time.reset();
        int len = trajectory.leftVel.size();
        for (int i = 0; i < len; i++) {
            // TODO: fix for negative error
            leftPoint = trajectory.leftPath.get(i);
            leftSError = MathFunctions.distance(drivetrain.getLeftPos(), leftPoint);

            double leftGoalVel = trajectory.leftVel.get(i);
            double leftGoalAcc = trajectory.leftAcc.get(i);

            rightPoint = trajectory.rightPath.get(i);
            rightSError = MathFunctions.distance(drivetrain.getRightPos(), rightPoint);

            double rightGoalVel = trajectory.rightVel.get(i);
            double rightGoalAcc = trajectory.rightAcc.get(i);

            dt = time.milliseconds() - prevTime;

            double leftPower = controller.PDVA(leftSError, prevLeftSError, dt, leftGoalVel, leftGoalAcc);
            double rightPower = controller.PDVA(rightSError, prevRightSError, dt, rightGoalVel, rightGoalAcc);

            prevTime = time.milliseconds();

            drivetrain.setLeftPower(leftPower);
            drivetrain.setRightPower(rightPower);

            prevLeftSError = leftSError;
            prevRightSError = rightSError;

        }
        drivetrain.stopMotors();

    }


}
