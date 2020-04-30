package com.paper;

import java.util.ArrayList;

public class Sketchbook extends NoteBook {
    private ArrayList<String> arts = new ArrayList<String> ();

    public Sketchbook(int numberOfPages, int thicknessOfPaper) {
        super (numberOfPages, thicknessOfPaper);
    }

    @Override
    public void use(String object) {
        draw (object);
    }

    private void draw(String art) {
        arts.add (art);
    }

    @Override
    public String toString() {
        return "Sketchbook {" +
                "\n arts = " + arts +
                ",\n numberOfPages = " + numberOfPages +
                ",\n thicknessOfPaper = " + thicknessOfPaper + " mm" +
                ",\n color = " + color +
                "\n}";
    }
}
