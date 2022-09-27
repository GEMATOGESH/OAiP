package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static long[] masComparison = new long[3];
    static long[] masPer = new long[3];
    static long[] masTime = new long[3];
    static ArrayList<Long> masSubPer = new ArrayList<>();
    static ArrayList<Long> masSubComparison = new ArrayList<>();

    // Метод вставки
    public static void insertionSort(Integer[] mas) {
        long numOfComparisons = 0;
        long numOfChanges = 0;
        long startTime = System.nanoTime();
        Integer[] array = mas.clone();

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                numOfComparisons++;
                array[j+1] = array[j];
                numOfChanges++;
                j--;
            }
            array[j+1] = current;
            numOfChanges++;
        }
        masTime[0] = System.nanoTime() - startTime;
        masComparison[0] = numOfComparisons;
        masPer[0] = numOfChanges;
    }

    // Методом выбора
    public static void selectionSort(Integer[] mas) {
        long numOfComparisons = 0;
        long numOfChanges = 0;
        long startTime = System.nanoTime();
        Integer[] array = mas.clone();

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    numOfComparisons++;
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
            numOfChanges++;
        }

        masTime[1] = System.nanoTime() - startTime;
        masComparison[1] = numOfComparisons;
        masPer[1] = numOfChanges;
    }

    // Рекурсивным (quicksort) методом
    static int partition(Integer[] array, int begin, int end) {
        long numOfComparisons = 0;
        long numOfChanges = 0;

        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++){
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
                numOfChanges++;
            }
            numOfComparisons++;
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        masSubComparison.add(numOfComparisons);
        masSubPer.add(numOfChanges);
        return i + 1;
    }

    public static void quickSort(Integer[] mas, int begin, int end) {
        long startTime = System.nanoTime();
        Integer[] array = mas.clone();

        if (begin < end) {
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot-1);
            quickSort(array, pivot+1, end);
        }

        long sum = 0;
        for (Long value : masSubComparison) sum += value;
        masComparison[2] = sum;
        sum = 0;
        for (Long aLong : masSubPer) sum += aLong;
        masPer[2] = sum;
        masTime[2] = System.nanoTime() - startTime;
    }

    public static void shuffle(Integer[] mas)
    {
        for (int i = 0; i < mas.length; i++){
            mas[i] = i;
        }

        List<Integer> intList = Arrays.asList(mas);
        Collections.shuffle(intList);
        intList.toArray(mas);
    }

    public static void answer(Integer[] mas){
        insertionSort(mas);
        selectionSort(mas);
        quickSort(mas, 0, 99);

        Arrays.sort(mas);
        insertionSort(mas);
        selectionSort(mas);
        quickSort(mas, 0, 99);

        Arrays.sort(mas, Collections.reverseOrder());
        insertionSort(mas);
        selectionSort(mas);
        quickSort(mas, 0, 99);

        System.out.println("mas[" + mas.length + "]");
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0 -> System.out.println("Not sorted:");
                case 1 -> System.out.println("Sorted:");
                case 2 -> System.out.println("Sorted backwards:");
                default -> System.out.println("how???");
            }
            System.out.print("Used time(nanoseconds): " + masTime[i] + " ");
            System.out.print("Comparisons: " + masComparison[i] + " ");
            System.out.print("Changes: " + masPer[i] + " ");
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Integer[] mas1 = new Integer[100];
        Integer[] mas2 = new Integer[10000];
        Integer[] mas3 = new Integer[100000];

        shuffle(mas1);
        shuffle(mas2);
        shuffle(mas3);

        answer(mas1);
        answer(mas2);
        answer(mas3);
    }
}
