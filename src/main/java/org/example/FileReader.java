package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FileReader() {
        this.filePath = "src/main/resources/test.txt";
        this.fromLine = 0;
        this.toLine = 3;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if ((toLine < fromLine) || (fromLine < 1)) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return Files.readString(Path.of(this.filePath), StandardCharsets.UTF_8);
    }

    public String readLines() throws IOException {
        String content = read();
        String[] lines = content.split("\n");
        List<String> selectedLines = Arrays.asList(lines).subList(this.fromLine, this.toLine);

        return String.join("\n", selectedLines).replaceAll("[\\p{Punct}]", "").toLowerCase();
    }
}
