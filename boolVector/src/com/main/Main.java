package com.main;

import com.boolVector.BoolVector;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] array = new int[]{1, 0, 1, 0};
        BoolVector boolVector = new BoolVector(array);
        BoolVector boolVector1 = new BoolVector (new int[]{1,0,0,0});

        System.out.println ("-----------------------------------------");
        System.out.println ("vector 1:");
        System.out.println (boolVector);
        System.out.println ("vector 2:");
        System.out.println (boolVector1);
        System.out.println ("Conjunction of vectors:");
        System.out.println (boolVector.conjunctionVectors (boolVector1));
        System.out.println ("Disjunction of vectors:");
        System.out.println (boolVector.disjunctionVectors (boolVector1));
        System.out.println ("Negation of vector 1:");
        System.out.println (boolVector.negationOfVector ());
        System.out.println ("-----------------------------------------");

        System.out.println ("Write dimension of vector");
        Scanner input = new Scanner(System.in);
        int dimension = input.nextInt ();
        BoolVector boolVector2 = new BoolVector(dimension);
        System.out.println (boolVector2);
    }
}
