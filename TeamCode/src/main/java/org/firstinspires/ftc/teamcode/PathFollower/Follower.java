package org.firstinspires.ftc.teamcode.PathFollower;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Util.MathFunctions;

import java.util.ArrayList;

public class Follower {

    private Drivetrain drivetrain;
    private Controller controller;

    private LinearOpMode opMode;

    // iterate through points to follow velocities
    // assuming equal dt steps
    public void followTrajectory(ArrayList<Point> leftPath, ArrayList<Point> rightPath,
                                 ArrayList<Double> leftVel, ArrayList<Double> leftAcc,
                                 ArrayList<Double> rightVel, ArrayList<Double> rightAcc, double dt) throws InterruptedException{

        Drivetrain drivetrain = new Drivetrain(opMode);

        double leftSError;
        double rightSError;

        Point leftCurrPoint = leftPath.get(0);
        Point leftNextPoint = leftPath.get(1);
        double prevLeftSError = MathFunctions.distance(leftCurrPoint, leftNextPoint);

        Point rightCurrPoint = rightPath.get(0);
        Point rightNextPoint = rightPath.get(1);
        double prevRightSError = MathFunctions.distance(rightCurrPoint, rightNextPoint);

        // TODO: change method for current inches?
        int len = leftVel.size();
        for (int i = 0; i < len; i++) {
            leftCurrPoint = leftPath.get(i);
            leftNextPoint = leftPath.get(i + 1);
            // TODO: fix for negative error
            leftSError = MathFunctions.distance(leftCurrPoint, leftNextPoint);

            double leftGoalVel = leftVel.get(i);
            double leftGoalAcc = leftAcc.get(i);

            rightCurrPoint = rightPath.get(i);
            rightNextPoint = rightPath.get(i + 1);
            rightSError = MathFunctions.distance(rightCurrPoint, rightNextPoint);

            double rightGoalVel = rightVel.get(i);
            double rightGoalAcc = rightAcc.get(i);

            double leftPower = controller.PDVA(leftSError, prevLeftSError, dt, leftGoalVel, leftGoalAcc);
            double rightPower = controller.PDVA(rightSError, prevRightSError, dt, rightGoalVel, rightGoalAcc);

            drivetrain.setLeftPower(leftPower);
            drivetrain.setRightPower(rightPower);

            prevLeftSError = leftSError;
            prevRightSError = rightSError;
        }

        drivetrain.stopMotors();
    }


}
