package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hello {
    public static void hello() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        System.out.println ("Привет, " + input.nextLine ());
    }

    public static void array() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        int[] array = new int[size];

        System.out.println("Введите числа массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        ArrayList<Integer> arrayOfEven = new ArrayList<>();
        ArrayList<Integer> arrayOfOdd = new ArrayList<>();
        ArrayList<Integer> arrayOfHalfSum = new ArrayList<>();
        int numOfEven = 0;
        int numOfOdd = 0;

        for (int value : array) {
            if (value % 2 == 0) {
                arrayOfEven.add (numOfEven, value);
                numOfEven++;
            } else {
                arrayOfOdd.add (numOfOdd, value);
                numOfOdd++;
            }
        }

        int num = 0;
        for (int i = 1; i < array.length - 1; ++i) {
            arrayOfHalfSum.add (num, (array[ i -1 ] + array[ i +1 ]) / 2);
            num++;
        }

        System.out.println ("Origin array: ");
        System.out.println(Arrays.toString (array));

        System.out.println("Even numbers: ");
        System.out.println(arrayOfEven);
        System.out.println("Odd numbers: ");
        System.out.println(arrayOfOdd);

        System.out.println("Array of half sums: ");
        System.out.println(arrayOfHalfSum);
    }
}
