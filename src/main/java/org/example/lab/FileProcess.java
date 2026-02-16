package org.example.lab;

import org.example.lab.exception.FileMissingException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcess {
    public void readFile(String filePath) throws FileMissingException, IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new FileMissingException("File " + filePath +" is missing!");
        }
    }
}
