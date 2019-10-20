package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Sensors {
    private LinearOpMode opMode;

    public BNO055IMU gyro;
    private Orientation angles;

    public Sensors(LinearOpMode opMode) throws InterruptedException {
        this.opMode = opMode;

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        gyro = this.opMode.hardwareMap.get(BNO055IMU.class, "imu");
        gyro.initialize(parameters);

    }

    public void updateGyroValues() {
        angles = gyro.getAngularOrientation();

    }

    // TODO: gyro testing
    // convert to 0-360
    public double getGyroYaw() {
        updateGyroValues();
        return angles.firstAngle * (Math.PI / 180);
    }

    public double getGyroPitch() {
        updateGyroValues();
        return angles.secondAngle;

    }

    public double getGyroRoll() {
        updateGyroValues();
        return angles.thirdAngle;

    }

}