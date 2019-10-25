package org.firstinspires.ftc.teamcode.Test;

import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        System.out.println(TestMethods.getLeftPos(1,1,Math.PI/4, 0));
        System.out.println(TestMethods.getRightPos(1,1,Math.PI/4, 0));
    }
}
