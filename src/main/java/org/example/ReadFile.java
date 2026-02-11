package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    public void readFromResource() {
        try(InputStream inputStream =  getClass().getResourceAsStream("data.txt");
            BufferedReader reader= new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
