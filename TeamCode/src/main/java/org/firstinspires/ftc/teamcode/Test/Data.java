package org.firstinspires.ftc.teamcode.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {

    public String getDirectory() {
        return new File("").getAbsolutePath();
    }

    public void createCSV(String name) throws IOException {
        PrintWriter writer = new PrintWriter(getDirectory());
        writ
    }
}
