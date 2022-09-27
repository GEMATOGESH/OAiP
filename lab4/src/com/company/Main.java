package com.company;

import java.util.Scanner;

public class Main {

    public static int answer(int a, int b) {
        if (b == 0) return 0;
        if (b%2 == 0) return 2 * answer( a, b/2 );
        else
            return a + answer(a,b-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        System.out.print("a = ");
        a = in.nextInt();
        System.out.print("b = ");
        b = in.nextInt();
        System.out.println("p (recursion) = " + answer(a, b));

        int p;
        if (b == 0)
            p = 0;
        else
            if (b % 2 == 0)
                p = 2 * (a * b / 2);
            else
                p = a + (a * (b - 1));
        System.out.println("p (normal) = " + p);
    }
}
