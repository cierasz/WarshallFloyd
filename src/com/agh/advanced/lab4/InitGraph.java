package com.agh.advanced.lab4;

import java.io.IOException;
import java.io.*;

public class InitGraph {

    public static int[][] graphMapFile(String filename) {

        String separator = "; ";
        String[] parsedLine;
        String line = "";

        int[][] graphMap = new int[21][21];

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                    parsedLine = line.split(separator);
                    graphMap[Integer.valueOf(parsedLine[0])][Integer.valueOf(parsedLine[1])] = Integer.valueOf(parsedLine[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graphMap;
    }
}
