package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class MaxVelAccTesting extends LinearOpMode {

    private Drivetrain drivetrain;
    private ElapsedTime elapsedTime;

    private double prevTime;

    private double prevInches;
    private double inches;

    private double prevVel;
    private double vel;

    private double acc;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addLine("Initialized");

        waitForStart();

        elapsedTime = new ElapsedTime();

        elapsedTime.reset();
        while (elapsedTime.milliseconds() < 7000) {
            drivetrain.setDrivePower(1);

            inches = drivetrain.getInches();
            vel = drivetrain.getVel(prevInches, inches, prevTime, elapsedTime.milliseconds());
            acc = drivetrain.getAcc(prevVel, vel, prevTime, elapsedTime.milliseconds());

            telemetry.addData("Velocity", vel);
            telemetry.addData("Acceleration", acc);
            telemetry.addLine("");

            prevTime = elapsedTime.milliseconds();
            prevInches = inches;
            prevVel = vel;
        }
        drivetrain.stopMotors();

    }
}
