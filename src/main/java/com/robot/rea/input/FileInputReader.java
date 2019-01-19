package com.robot.rea.input;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileInputReader implements InputReader {
    @Override
    public List<String> getCommandsFromUser(String str) {
        try {
            String path2 = this.getClass().getResource(str).getPath();
            Path path = Paths.get(path2);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            return lines;

        } catch (Exception ex) {
            System.out.println("Invalid file path location");
            return null;
        }
    }
}
