package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.PathFollower.Follower;
import org.firstinspires.ftc.teamcode.PathGeneration.Point;
import org.firstinspires.ftc.teamcode.PathGeneration.CSVFunctions;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

import java.util.ArrayList;

@Autonomous (name = "Test", group = "Auto")
public class MotionProfileTest extends LinearOpMode {
    private LinearOpMode opMode;

    private Follower follower;
    private CSVFunctions csvFunctions;

    @Override
    public void runOpMode() throws InterruptedException{
        telemetry.addLine("Initialized");

        Drivetrain drivetrain = new Drivetrain(opMode);

        waitForStart();

        //TODO: when to put spline to trajectory in csv?

        ArrayList<Point> leftPath = csvFunctions.getCSVPath();
        ArrayList<Point> rightPath = csvFunctions.getCSVPath();

        ArrayList<Double> leftVel = csvFunctions.getCSVValues();
        ArrayList<Double> leftAcc = csvFunctions.getCSVValues();

        ArrayList<Double> rightVel = csvFunctions.getCSVValues();
        ArrayList<Double> rightAcc = csvFunctions.getCSVValues();

        double dt = 0.05;

        follower.followTrajectory();
    }
}
