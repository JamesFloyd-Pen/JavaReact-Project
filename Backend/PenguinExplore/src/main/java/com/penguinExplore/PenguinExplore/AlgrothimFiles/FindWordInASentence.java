package com.penguinExplore.PenguinExplore.AlgrothimFiles;

public class FindWordInASentence {
    public static void main(String[] args) {
        String sentence = "The quick brownfox jumps over the lazy dog";
        String wordToFind = "fox";
        boolean found = findWordInSentence(sentence, wordToFind);
        System.out.println("Word found: " + found);
    }

    static boolean findWordInSentence(String sentence, String word) {
        // Use word boundaries \b to match complete words only
        // This ensures "fox" won't match in "brownfox"
        String pattern = "\\b" + word + "\\b";
        return sentence.matches(".*" + pattern + ".*");
    }
    
}
