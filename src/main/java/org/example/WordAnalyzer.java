package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordAnalyzer {

    private FileReader fileReader;

    public WordAnalyzer(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<String> getWordsSortedAlphabetically() throws IOException {
        String[] words = fileReader.readLines().split("\\s+");
        Arrays.sort(words);
        return Arrays.asList(words);
    }

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        List<String> list = new ArrayList<>();
        String[] words = fileReader.readLines().split("\\s+");
        for (String word : words) {
            if (word.contains(substring)) {
                list.add(word);
            }
        }
        return list;
    }

    public List<String> getPalindromicWords() throws IOException {
        List<String> list = new ArrayList<>();
        String[] words = fileReader.readLines().split("\\s+");
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (word.equals(reverse)) {
                list.add(word);
            }
        }
        return list;
    }
}
