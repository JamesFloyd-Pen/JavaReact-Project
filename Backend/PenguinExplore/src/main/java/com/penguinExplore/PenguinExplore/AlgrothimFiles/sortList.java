package com.penguinExplore.PenguinExplore.AlgrothimFiles;

import java.util.Arrays;

public class sortList {

    public static void main(String[] args) {
        //int[] arr0 = { 5, 4, 3, 2, 1 };
        //Arrays.sort(arr0);
        //printArray(arr0);
        //System.err.println("--------------------");

        int[] arr = { 2, 1, 3, 5, 4, 7, 6 };
        arr = mergeSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] n) {
        for (int i : n) {
            System.out.print(i + " ");
        }
    }

    public static int[] bubbleSort(int[] n) {

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length - i - 1; j++) {
                if (n[j] > n[j + 1]) {
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;

                }
            }
        }
        return n;
    }

    public static int[] selectionSort(int[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] < n[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = n[minIndex];
            n[minIndex] = n[i];
            n[i] = temp;
        }
        return n;
    }

    public static int[] insertionSort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int key = n[i];
            int j = i - 1;
            while (j >= 0 && n[j] > key) {
                n[j + 1] = n[j];
                j--;
            }
            n[j + 1] = key;
        }
        return n;
    }

    public static int[] mergeSort(int[] n) {
        if (n.length < 2) {
            return n;
        }
        int mid = n.length / 2;
        int[] left = Arrays.copyOfRange(n, 0, mid);
        int[] right = Arrays.copyOfRange(n, mid, n.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        //System.out.println("The merge array length from a L + R: " + result.length);
        printArray(result);
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        System.out.println("\n Space");
        printArray(result);
  
        return result;
    }



}
