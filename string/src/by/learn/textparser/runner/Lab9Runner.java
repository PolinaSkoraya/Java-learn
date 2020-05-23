package by.learn.textparser.runner;

import by.learn.textparser.components.Sentence;
import by.learn.textparser.components.Word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab9Runner {
    public static void main(String[] args) {
        String path = "D:\\Univer_labs\\JAVA\\string\\text.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader (path))) {
            String line;
            StringBuilder text = new StringBuilder ();
            while ((line = reader.readLine()) != null) {
                Sentence sentence = new Sentence (line);
                List<Word> words = sentence.parse ();
                List<Word> newWords = new ArrayList<> ();

                for (Word word: words) {
                    newWords.add (word.firstUpperCase());
                }

                Sentence newSentence = new Sentence (newWords);
                text.append (newSentence);
                text.append ("\n");
            }

            FileWriter fw = new FileWriter ( "textOut.txt" );
            fw.write (String.valueOf (text));
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}