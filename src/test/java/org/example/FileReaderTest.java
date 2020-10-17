package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        this.fileReader = new FileReader();
    }

    @Test
    void should_throwException_when_toLineHasALowerValueThanFromLine() {
        assertThrows(IllegalArgumentException.class,
                () -> fileReader.setup("file.txt", 1, -5)
        );
    }

    @Test
    void should_throwException_when_fromLineValueIsLessThanOne() {
        assertThrows(IllegalArgumentException.class,
                () -> fileReader.setup("file.txt", -5, 5)
        );
    }

    @Test
    void should_throwException_when_filePathIsWrong() {
        fileReader.setup("file.txt", 1, 5);
        assertThrows(IOException.class,
                () -> fileReader.read()
        );
    }

    @Test
    void should_returnProperLines_when_fromLineAndToLineAreSpecifiedCorrectly() throws IOException {
        fileReader.setup("src/main/resources/test1.txt", 3, 4);
        String expectedContent = "gregor then turned to look out the window at the dull weather\n" +
                "drops of rain could be heard hitting the pane";
        String actualContent = fileReader.readLines();
        assertEquals(expectedContent, actualContent);
    }

    @Test
    void should_returnFirstLine_when_fromLineAndToLineEqualOne() throws IOException {
        fileReader.setup("src/main/resources/test1.txt", 1, 1);
        String expectedContent = "one morning when gregor samsa woke from troubled dreams";
        String actualContent = fileReader.readLines();
        assertEquals(expectedContent, actualContent);
    }

    @Test
    void should_returnSingleSpecificLine_when_fromLineIsTheSameAsToLine() throws IOException {
        fileReader.setup("src/main/resources/test1.txt", 4, 4);
        String expectedContent = "drops of rain could be heard hitting the pane";
        String actualContent = fileReader.readLines();
        assertEquals(expectedContent, actualContent);
    }
}
