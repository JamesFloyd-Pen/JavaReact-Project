package com.penguinExplore.PenguinExplore.AlgrothimFiles;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class CodeChallenge {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 4, 1, 5, 3};
        input = removeDuplicatesWithOrder(input);

        for (int i : input) {
            System.out.println(i);
            
        }

        
    }

    // Alternative approach that preserves original order
    public static int[] removeDuplicatesWithOrder(int[] arr) {
        //Sets a nLinkedHashSet. Deletes duplicates
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        //Add the array elements into the set
        for (int num : arr) {
            set.add(num);
        }
        
        //A new array
        int[] result = new int[set.size()];
        //Unique. Will add new elements in the empty result array 
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        //Returns result
        return result;
    }
    
}
