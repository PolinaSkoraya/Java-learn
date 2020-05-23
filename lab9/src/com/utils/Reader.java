package com.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String fromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder text = new StringBuilder ();
            while ((line = reader.readLine()) != null) {
                text.append (line);
            }
            return text.toString ();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
