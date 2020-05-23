package by.learn.textparser.utils;

import by.learn.textparser.components.Sentence;
import by.learn.textparser.components.Symbol;
import by.learn.textparser.components.Text;
import by.learn.textparser.components.Word;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static int numberOfWords(Text text) {
        List<Sentence> sentences = text.parse();
        int numberOfWords = 0;

        for (Sentence sentence : sentences) {
            numberOfWords = numberOfWords + sentence.parse ().size ();
        }

        return numberOfWords;
    }

    public static int cost (Text text, int price) {
        return numberOfWords (text) * price;
    }

    public static void maxSequence(Text text) {
        List<Sentence> sentences = text.parse ();
        List<Word> words = new ArrayList<> ();

        List<Word> maxSequence = new ArrayList<> ();

        for (Sentence sentence: sentences) {
            List<Word> tempWords = sentence.parse ();
            words.addAll (tempWords);
        }

        for (int i = 0; i < words.size (); i++) {
            List<Word> currSequence = new ArrayList<> ();
            currSequence.add (words.get (i));

            List<Symbol> symbols1 = words.get (i).parse();

            for (int j = 0; j < words.size (); j++) {
                if (i != j) {
                    List<Symbol> symbols2 = words.get (j).parse();
                    if (symbols1.get (symbols1.size () - 1).equals (symbols2.get (0))) {
                        currSequence.add (words.get (j));
                    }
                }
            }

            if (currSequence.size () > maxSequence.size ()) {
                maxSequence = currSequence;
            }
            System.out.println (currSequence);
        }

        System.out.println ("\nmaxSequence");
        System.out.println (maxSequence);
    }
}
