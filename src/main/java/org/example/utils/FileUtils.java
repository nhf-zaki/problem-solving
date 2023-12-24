package org.example.utils;

public class FileUtils {

    private static final String outputPath = System.getProperty("user.dir") + "/out/output.txt";
    private static final String inputPath = System.getProperty("user.dir") + "/out/input.txt";

    public static String getOutputPath() {
        return outputPath;
    }
    public static String getInputPath() {
        return inputPath;
    }
}
