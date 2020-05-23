package com.matrix;

/**
 * <h3>Find saddle points.<h3/>
 * @autor Skoraya Polina
 * @version 1.0.0
 */

import com.matrixElement.MatrixElement;
import task2.DifferentNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static MatrixElement getSaddlePoint (int[][] array) {
        MatrixElement saddlePoint = null;

        int minI, minJ, min;
        int maxI, maxJ, max;

        ArrayList<MatrixElement> arrayOfMin = new ArrayList<> ();
        ArrayList<MatrixElement> arrayOfMax = new ArrayList<> ();

        for (int i = 0; i < array.length; i++) {
            minI = i;
            minJ = 0;
            min = array[i][0];

            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    minI = i;
                    minJ = j;
                }
            }

            arrayOfMin.add(new MatrixElement(minI, minJ, min));
        }

        for (int j = 0; j < array[0].length; j++) {
            maxI = 0;
            maxJ = j;
            max = array[0][j];

            for (int i = 0; i < array.length; i++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }

            arrayOfMax.add(new MatrixElement(maxI, maxJ, max));
        }

        int i = 0;
        while ((i < arrayOfMin.size()) && (saddlePoint == null)) {
            int j = 0;
            while ((j < arrayOfMax.size()) && (saddlePoint == null)) {
                if (arrayOfMin.get(i).equals(arrayOfMax.get(j))) {
                    saddlePoint = new MatrixElement(arrayOfMin.get(i));
                }
                j++;
            }
            i++;
        }

        return saddlePoint;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        int size = input.nextInt();
        int[][] randomArray = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                randomArray[i][j] = (int) (Math.random () * 10);
            }
        }
        System.out.println ("Random matrix: ");
        System.out.println (Arrays.deepToString (randomArray));
        System.out.println ("Saddle point of random matrix: ");
        MatrixElement saddlePointOfRandomArray = getSaddlePoint(randomArray);

        if (saddlePointOfRandomArray != null) {
            System.out.println(saddlePointOfRandomArray);
        } else {
            System.out.println("No saddle points in random matrix");
        }

        int[][] array = { { 5, 6, 4, 5 }, { -2, 5, 3, 7 }, { 8, 7, -2, 6 }, {0, 0, 0, 0} };
        System.out.println ("\nMatrix: ");
        System.out.println (Arrays.deepToString (array));
        System.out.println ("Saddle point of matrix: ");
        MatrixElement saddlePoint = getSaddlePoint(array);

        if (saddlePoint != null) {
            System.out.println(saddlePoint);
        } else {
            System.out.println("No saddle points in matrix");
        }

        DifferentNumbers.searchNumber ();

        System.out.print("\nДата и время сдачи задания:\n");
        Date date = new Date ();
        System.out.println(date.toString());
    }
}
