package com.main;

import com.paper.NoteBook;
import com.paper.Sketchbook;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        NoteBook book = new Sketchbook (6, 1);
        System.out.println (book);

        System.out.println ("Draw something: ");

        String objectToDraw = getScanner().nextLine ();
        book.use(objectToDraw);

        System.out.println (book);
    }

    public static Scanner getScanner() {
        return new Scanner (System.in);
    }
}
