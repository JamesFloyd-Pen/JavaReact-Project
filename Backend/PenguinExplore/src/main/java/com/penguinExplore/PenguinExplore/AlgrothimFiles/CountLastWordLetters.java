package com.penguinExplore.PenguinExplore.AlgrothimFiles;

/**
 * Class to count the number of letters in the last word of a string.
 */

public class CountLastWordLetters {
    /**
     * Counts the number of letters in the last word of the given string.
     *
     * @param input The input string.
     * @return The number of letters in the last word.
     */
    public static void main(String[] args) {
        CountLastWordLetters counter = new CountLastWordLetters();
        String testString = "Hello World IloveJOINCENA ";
        int result = counter.lengthOfLastWord(testString);
        System.out.println("Number of letters in the last word: " + result); 
    }

    // run time O(n)
    public int lengthOfLastWord(String s) {
        s = s.trim();
        System.out.println(s);
        int letterCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                letterCount++;
            } else if (letterCount > 0) {
                break;

            }

        }

        return letterCount;
    }

}
