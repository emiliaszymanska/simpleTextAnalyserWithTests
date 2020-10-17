package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordAnalyzerTest {

    private WordAnalyzer wordAnalyzer;
    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        this.fileReader = new FileReader();
        this.wordAnalyzer = new WordAnalyzer(fileReader);
    }

    @Test
    void should_returnListOfWordsSortedAlphabetically() throws IOException {
        List<String> expectedContent = new ArrayList<>(
                Arrays.asList("anna", "civic", "level", "madam", "radar", "symmetry", "synchronize")
        );
        Collections.sort(expectedContent);
        List<String> actualContent = wordAnalyzer.getWordsSortedAlphabetically();
        assertEquals(expectedContent, actualContent);
    }

    @Test
    void should_returnWordsContainingSubstring_when_wordsContainingSubstringOccur() throws IOException {
        List<String> expectedContent = new ArrayList<>(
                Arrays.asList("symmetry", "synchronize")
        );
        List<String> actualContent = wordAnalyzer.getWordsContainingSubstring("sy");
        assertEquals(expectedContent, actualContent);
    }

    @Test
    void should_returnEmptyList_when_wordsContainingSubstringDoNotOccur() throws IOException {
        List<String> expectedContent = new ArrayList<>();
        List<String> actualContent = wordAnalyzer.getWordsContainingSubstring("zebra");
        assertEquals(expectedContent, actualContent);
    }

    @Test
    void should_returnListOfPalindromicWords_when_palindromicWordsOccur() throws IOException {
        List<String> expectedContent = new ArrayList<>(
                Arrays.asList("anna", "level", "radar", "civic", "madam")
        );
        List<String> actualContent = wordAnalyzer.getPalindromicWords();
        Collections.sort(expectedContent);
        Collections.sort(actualContent);
        assertEquals(expectedContent, actualContent);
    }
}
