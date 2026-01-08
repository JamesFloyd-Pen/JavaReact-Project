package com.penguinExplore.PenguinExplore.AlgrothimFiles;

import java.util.ArrayList;

public class nextLargestElement {

    public static void main(String[] args) {
        int[] arr = { 4, 40, 2, 1, 6};
        ArrayList<Integer> results = nextLargerElement(arr);
        for(int x : results){
            System.out.println(x+ " ");
        }
    }
    
    static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            result.add(-1);
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[i]){
                    result.set(i, arr[j]);
                    break;
                }
            }
        }

        return result;
    }


}
