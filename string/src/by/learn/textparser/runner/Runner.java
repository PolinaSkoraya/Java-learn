package by.learn.textparser.runner;

import by.learn.textparser.components.Sentence;
import by.learn.textparser.components.Text;
import by.learn.textparser.components.Word;
import by.learn.textparser.utils.Reader;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\Univer_labs\\JAVA\\string\\test.txt";
        Text text = new Text(Reader.fromFile(path));
        System.out.println (text);

        Text newText = null;

        List<Sentence> sentences = text.parse ();
        List<Sentence> newSentences = new ArrayList<> ();

        for (Sentence sentence: sentences) {
            List<Word> words = sentence.parse ();
            List<Word> newWords = new ArrayList<> ();

            for (Word word: words) {
                newWords.add (word.filter (false));
            }

            Sentence newSentence = new Sentence (newWords);
            newSentences.add (newSentence);
        }

        newText = new Text (newSentences);

        System.out.println (newText);
    }
}
