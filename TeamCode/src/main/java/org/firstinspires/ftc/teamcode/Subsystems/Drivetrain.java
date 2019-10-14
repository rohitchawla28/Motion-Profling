package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {

    private LinearOpMode opMode;
    private Sensors sensors;

    private DcMotor fl, fr, bl, br;

    private final double ticksRev = 383.6;
    private final double ratio = 1.0;
    private final double diam = 4.0;
    private final double cpi = (ticksRev * ratio) / (diam * Math.PI);

    public Drivetrain(LinearOpMode opMode) throws InterruptedException{
        this.opMode = opMode;

        fl = this.opMode.hardwareMap.dcMotor.get("fl");
        fr = this.opMode.hardwareMap.dcMotor.get("fr");
        bl = this.opMode.hardwareMap.dcMotor.get("bl");
        br = this.opMode.hardwareMap.dcMotor.get("br");

        sensors = new Sensors(opMode);

        fl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.FORWARD);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        resetEncoders();
    }

    // ==================================  UTILITY  =============================================
    public void setDrivePower(double power) {
        fl.setPower(power);
        fr.setPower(power);
        bl.setPower(power);
        br.setPower(power);
    }

    public void setLeftPower(double power) {
        fr.setPower(power);
        br.setPower(power);
    }

    public void setRightPower(double power) {
        fr.setPower(power);
        br.setPower(power);
    }

    public void stopMotors() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }

    public void resetEncoders() {
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        opMode.idle();

        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        opMode.idle();

    }


    // ==========================================  ENCODER  ========================================
    public double getInches() {
        int zeros = 0;

        if (fl.getCurrentPosition() == 0) {
            zeros++;
        }
        if (fr.getCurrentPosition() == 0) {
            zeros++;
        }
        if (bl.getCurrentPosition() == 0) {
            zeros++;
        }
        if (br.getCurrentPosition() == 0) {
            zeros++;
        }

        return (fl.getCurrentPosition() +
                fr.getCurrentPosition() +
                bl.getCurrentPosition() +
                br.getCurrentPosition()) / (4- zeros);
    }

    public double getLeftInches() {
        int zeros = 0;

        if (fl.getCurrentPosition() == 0) {
            zeros++;
        }
        if (bl.getCurrentPosition() == 0) {
            zeros++;
        }

        return ((fl.getCurrentPosition() / cpi) + (bl.getCurrentPosition() / cpi)) / (2.0 - zeros);
    }

    public double getRightInches() {
        int zeros = 0;

        if (fr.getCurrentPosition() == 0) {
            zeros++;
        }
        if (br.getCurrentPosition() == 0) {
            zeros++;
        }

        return ((fr.getCurrentPosition() / cpi) + (br.getCurrentPosition() / cpi)) / (2.0 - zeros);
    }

    // ========================================  TELEMETRY  ========================================
    public double getVel(double prevInches, double inches, double prevTime, double time) {
        return (inches - prevInches) / (time - prevTime);
    }

    public double getAcc(double prevVel, double vel, double prevTime, double time) {
        return (vel - prevVel) / (time - prevTime);
    }

}
