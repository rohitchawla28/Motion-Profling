package org.firstinspires.ftc.teamcode.PathFollower;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

import java.util.ArrayList;

public class Follower {

    private Drivetrain drivetrain;
    private Controller controller;

    // iterate through points to follow velocities
    public void followTrajectory(ArrayList<Point> leftPath, ArrayList<Point> rightPath,
                                 ArrayList<Double> leftVel, ArrayList<Double> leftAcc,
                                 ArrayList<Double> rightVel, ArrayList<Double> rightAcc, double dt) {

        double prevLeftSError;
        double prevRightSError;

        int len = leftVel.size();
        for (int i = 0; i < len; i++) {
            Point leftCurrPoint = leftPath.get(i);
            Point leftNextPoint = leftPath.get(i + 1);
            double leftGoalVel = leftVel.get(i);
            double leftGoalAcc = leftAcc.get(i);

            double leftPower = controller.PDVA(leftCurrPoint, leftNextPoint, dt);

            Point rightCurr = rightPath.get(i);
            double rightGoalVel = rightVel.get(i);
            double rightGoalAcc = rightAcc.get(i);

            drivetrain.setLeftPower(controller.PDVA(leftCurrPoint, leftNextPoint, ));

            prevLeftSError =
        }
    }


}
