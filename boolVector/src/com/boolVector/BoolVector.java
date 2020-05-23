package com.boolVector;

import java.util.Arrays;
import java.util.Scanner;

public class BoolVector {
    private int[] vector;
    private int dimension;
    private int weight;
    private int numberOfZeroes;

    public BoolVector(int[] vector) {
        this.vector = vector;
        this.dimension = vector.length;
        this.weight = calcWeight();
        this.numberOfZeroes = vector.length - weight;
    }

    public BoolVector(int dimension) {
        this.dimension = dimension;
        this.vector = new int[dimension];
        Scanner input = new Scanner(System.in);
        System.out.println ("write elements of bool vector");
        for (int i = 0; i < dimension; i++) {
            this.vector[i] = input.nextInt();
        }
        this.weight = calcWeight();
        this.numberOfZeroes = vector.length - weight;
    }

    public BoolVector conjunctionVectors (BoolVector boolVector) {
        int[] array = new int[boolVector.vector.length];

        for (int i = 0; i< boolVector.vector.length; i++) {
            if (this.vector[i] == 1 && boolVector.vector[i] == 1) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        return new BoolVector (array);
    }

    public BoolVector disjunctionVectors (BoolVector boolVector) {
        int[] array = new int[boolVector.vector.length];

        for (int i = 0; i< boolVector.vector.length; i++) {
            if (this.vector[i] == 0 && boolVector.vector[i] == 0) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }

        return new BoolVector (array);
    }


    public BoolVector negationOfVector () {
        int[] array = new int[this.vector.length];

        for (int i = 0; i< this.vector.length; i++) {
            if (this.vector[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        return new BoolVector (array);
    }

    private int calcWeight () {
        int weight = 0;
        for (int i = 0; i < this.vector.length; i++) {
            if (this.vector[i] == 1) {
                weight++;
            }
        }
        return weight;
    }

    public int[] getVector() {
        return vector;
    }

    public int getDimension() {
        return dimension;
    }

    public int getWeight() {
        return weight;
    }

    public int getNumberOfZeroes() {
        return numberOfZeroes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder ("BoolVector{");
        sb.append ("vector=").append (Arrays.toString (vector));
        sb.append (", dimension=").append (dimension);
        sb.append (", weight=").append (weight);
        sb.append (", numberOfZeroes=").append (numberOfZeroes);
        sb.append ('}');
        return sb.toString ();
    }
}
