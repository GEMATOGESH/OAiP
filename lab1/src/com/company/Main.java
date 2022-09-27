package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	    int n;
	    System.out.print("N = ");
	    n = in.nextInt();
        double[] b = new double[n + 1];
        Random r = new Random();
        for (int i = 1; i < n + 1; i++){
            b[i] = 10 * (r.nextDouble());
        }
        double max = b[1];
        double min = b[1];
        for (int i = 1; i < n + 1; i++){
            System.out.printf("%.2f " ,b[i]);
            if (b[i] > max)
                max = b[i];
            if (b[i] < min)
                min = b[i];
        }
        double C = min + max;
        System.out.println();
        System.out.printf("Max = %.2f\n", max);
        System.out.printf("Min = %.2f\n", min);
        System.out.printf("C = %.2f + %.2f = %.2f\n", min, max, C);
        double[] Y = new double[n + 1];
        for (int i = 1; i < n + 1; i++){
            if (b[i] > 1)
                Y[i] = b[i] + C;
            else
                Y[i] = Math.pow((Math.pow(b[i] * C + 1, 2)), 1.0/3);
            System.out.printf("Y[" + i + "] = %.2f", Y[i]);
            System.out.println();
        }
    }
}
