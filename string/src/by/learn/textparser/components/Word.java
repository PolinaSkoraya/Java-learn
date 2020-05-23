package by.learn.textparser.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word implements IParse {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word(List<Symbol> symbols) {
        char[] sym = new char[symbols.size ()];

        for(int i = 0; i < symbols.size (); i++) {
            sym[i] = symbols.get (i).getSymbol ();
        }

        this.word = String.valueOf (sym);
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return getWord().equalsIgnoreCase(word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }

    @Override
    public List<Symbol> parse() {
        char[] temporarySymbols = this.word.toCharArray ();
        List<Symbol> symbols = new ArrayList<> ();

        for(char temporarySymbol: temporarySymbols) {
            symbols.add(new Symbol (temporarySymbol));
        }

        return symbols;
    }

    public Word filter(boolean flag) {
        Word word = new Word (this.word);
        List<Symbol> symbols = word.parse ();

        if (flag) {
            for (int i = 1; i < symbols.size (); i++) {
                if (symbols.get (i).equals (symbols.get (0))) {
                    symbols.remove (i);
                    i--;
                }
            }
        } else {
            Symbol s = symbols.get (symbols.size () - 1);
            for (int i = 0; i < symbols.size () - 1; i++) {
                if (symbols.get (i).equals (s)) {
                    symbols.remove (i);
                    i--;
                }
            }
        }

        return new Word (symbols);
    }

    public Word firstUpperCase() {
        return new Word (word.substring(0, 1).toUpperCase() + word.substring(1));
    }
}
