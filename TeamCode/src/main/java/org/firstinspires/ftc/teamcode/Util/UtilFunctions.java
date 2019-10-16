package org.firstinspires.ftc.teamcode.Util;

import org.firstinspires.ftc.teamcode.PathGeneration.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class UtilFunctions {
    public static ArrayList<Point> hashMapToArrayList(HashMap<Double, Point> hashMap) {
        Collection<Point> hashValues = hashMap.values();

        return new ArrayList<Point>(hashValues);
    }
}
