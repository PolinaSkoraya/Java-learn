package com.paper;

import static com.main.Runner.getScanner;

public abstract class NoteBook implements Paper {
    protected int numberOfPages;
    protected int thicknessOfPaper;
    protected String color;

    public NoteBook(int numberOfPages, int thicknessOfPaper) {
        this.numberOfPages = numberOfPages;
        this.thicknessOfPaper = thicknessOfPaper;
        createProduct ();
    }

    @Override
    public void createProduct() {
        System.out.println ("Enter color of sketchbook: ");
        this.color = getScanner().nextLine ();
    }

    public abstract void use(String object);
}
