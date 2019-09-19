package com.agh.advanced.lab4;

import java.util.ArrayList;

public class Alg {
    private static int[][] d;
    private static int[][] poprzednik;

    public static void warshallFloyd(int[][] graphMap) {
        d = new int[21][21];
        poprzednik = new int[21][21];
        int v_1, v_2, u;

        for(v_1 = 1; v_1 < 21; v_1++) {
            for(v_2 = 1; v_2 < 21; v_2++) {
                d[v_1][v_2] = 214748364;
                poprzednik[v_1][v_2] = -1;
            }
            d[v_1][v_1] = 0;
        }
        for(v_1 = 1; v_1 < 21; v_1++) {
            for (v_2 = 1; v_2 < 21; v_2++) {
                if (graphMap[v_1][v_2] != 0) {
                    d[v_1][v_2] = graphMap[v_1][v_2];
                    poprzednik[v_1][v_2] = v_1;
                }
            }
        }
        for(u = 1; u < 21; u++) {
            for(v_1 = 1; v_1 < 21; v_1++) {
                for(v_2 = 1; v_2 < 21; v_2++) {
                    if (d[v_1][v_2] > d[v_1][u] + d[u][v_2]) {
                        d[v_1][v_2] = d[v_1][u] + d[u][v_2];
                        poprzednik[v_1][v_2] = poprzednik[u][v_2];
                    }
                }
            }
        }
    }

    public static int getDistnace(int v_1, int v_2) {
        return d[v_1][v_2];
    }

    public static void getPath(int v_1, int v_2) {
        ArrayList<Integer> path = new ArrayList<>();
        int u = poprzednik[v_1][v_2];
        path.add(v_2);
        path.add(u);

        while (u != v_1) {
            u = poprzednik[v_1][u];
            path.add(u);
        }
        for (int i = path.size() - 1; i >= 1; i--) {
            System.out.print(path.get(i) + " -> " + d[path.get(i)][path.get(i - 1)] + " -> ");
        }
        System.out.print(path.get(0));
    }

}

