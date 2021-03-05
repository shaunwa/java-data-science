package com.shaunwassell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {
    public static List<String> getLines(String filename) {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lines;
    }
}
