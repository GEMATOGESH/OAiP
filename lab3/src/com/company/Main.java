package com.company;
//piloramap ella ela elae ramuu ramu ramur ramu
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] subStr = str.split("\\s");
        HashSet<String> answer1 = new HashSet<>();
        StringBuilder answer2 = new StringBuilder();

        for (String item : subStr)
        {
            if (!item.equals(subStr[subStr.length - 1])) {
                char[] charArray1 = item.toUpperCase().toCharArray();
                for (int i = 0; i < item.length(); i++) {
                    for (int j = i + 1; j < item.length(); j++) {
                        if (charArray1[i] == charArray1[j]) {
                            answer1.add(item);
                            break;
                        }
                    }
                }

                answer2.append(item.charAt(0));
                for (int i = 1; i < item.length(); i++) {
                    if (item.toUpperCase().charAt(i) != item.toUpperCase().charAt(0))
                        answer2.append(item.charAt(i));
                }
                answer2.append(" ");
            }
        }

        System.out.print("Answer 1: ");
        for (String item : answer1) {
            System.out.print(item + " ");
        }
        if (answer1.size() == 0)
            System.out.print("It's clear or has only one word");
        System.out.println();
        System.out.print("Answer 2: " + answer2);
        if (answer2.length() == 0)
            System.out.print("It's clear or has only one word");
    }
}
