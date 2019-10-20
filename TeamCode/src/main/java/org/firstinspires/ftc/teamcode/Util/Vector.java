package org.firstinspires.ftc.teamcode.Util;

public class Vector {

    private double v1;
    private double v2;

    private double magnitude;

    private double unitV1;
    private double unitV2;

    public Vector(double x1, double y1, double x2, double y2) {
        v1 = x2 - x1;
        v2 = y2 - y1;

        setMagnitude();
        setUnitVector();
    }

    private void setMagnitude() {
        magnitude = Math.sqrt(Math.pow(v1, 2) + Math.pow(v2, 2));
    }

    private void setUnitVector() {
        unitV1 = v1 / magnitude;
        unitV2 = v2 / magnitude;
    }

    public double getUnitV1() {
        return unitV1;
    }

    public double getUnitV2() {
        return unitV2;
    }
}
