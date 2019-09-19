package com.agh.advanced.lab4;

import static com.agh.advanced.lab4.Alg.*;

public class Main {

    public static void main(String[] args) {

        int[][] graphMap = InitGraph.graphMapFile("C:\\Users\\Cierasze\\IdeaProjects\\WarshallFloyd\\resources\\graph\\test_graph.txt");
        warshallFloyd(graphMap);
        for (int i=0; i<21; i++) {
            for (int j=0; j<21; j++) {
                if(graphMap[i][j] < 10)
                    System.out.print("[ " + graphMap[i][j] + " ] ");
                else if(graphMap[i][j] > 9 && graphMap[i][j] < 100)
                        System.out.print("[ " + graphMap[i][j] + "] ");
                else System.out.print("[" + graphMap[i][j] + "] ");
            }
            System.out.println(" ");
        }
        System.out.println("Distance: " + getDistnace(1,20));
        System.out.println(" ");
        System.out.println("Path: ");
        getPath(1,20);
    }
}
