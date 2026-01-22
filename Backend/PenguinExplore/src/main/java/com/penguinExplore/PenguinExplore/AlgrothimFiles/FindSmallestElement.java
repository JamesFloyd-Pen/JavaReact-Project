package com.penguinExplore.PenguinExplore.AlgrothimFiles;

public class FindSmallestElement {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2};
        int smallest = findSmallestElement(array);
        System.out.println("The smallest element is: " + smallest);
        
    }

    static int findSmallestElement(int[] arr){
        int output = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < output){
                output = arr[i];
            }

        }


        return output;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    /*
     
    */

}
