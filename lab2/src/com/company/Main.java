package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n = ");
        int n = in.nextInt();
        int[][] x = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                x[i][j] = r.nextInt(9 + 9) - 9;
                if (x[i][j] >= 0)
                    System.out.print(" " + x[i][j] + " ");
                else
                    System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int temp;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                temp = x[i][j];
                x[i][j] = x[i][n - j - 1];
                x[i][n - j - 1] = temp;
            }
        }

        int maxs = 0;
        for(int offset = -n + 1; offset < n; ++offset) {
            if (offset != 0) {
                int sum = 0;
                for (int i = 0; i < n - Math.abs(offset); ++i) {
                    if (offset < 0)
                        sum += Math.abs(x[i - offset][i]);
                    if (offset > 0)
                        sum += Math.abs(x[i][i + offset]);
                }
                if (sum > maxs)
                    maxs = sum;
            }
        }

        System.out.println("Biggest sum: " + maxs);
    }
}
