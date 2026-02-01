package com.penguinExplore.PenguinExplore.AlgrothimFiles;

public class PalindromeChecker {
    public static void main(String[] args) {
        String testString = "civic";
        boolean isPalindrome = checkPalindrome(testString);
        System.out.println(isPalindrome);
    }

    public static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() -1;
        while(right > left){
            if(str.charAt(right) != str.charAt(left))
            {
                return false;
            }
            left++;
            right--;
        }


        return true;
    }
    
}
