package org.example;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader();
        WordAnalyzer wordAnalyzer = new WordAnalyzer(fileReader);

        wordAnalyzer.getWordsSortedAlphabetically();
        wordAnalyzer.getWordsContainingSubstring("sy");
        wordAnalyzer.getPalindromicWords();
    }
}
