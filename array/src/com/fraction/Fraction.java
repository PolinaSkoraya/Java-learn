package com.fraction;

import java.util.Arrays;
import java.util.Scanner;

public class Fraction {

    public static void showFractionPeriod() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        int[] array = new int[size];

        System.out.println("Введите числа массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        int[] twoPositiveNumbers = new int[2];
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] > 0) && (array[i + 1] > 0)) {
                twoPositiveNumbers[0] = array[i];
                twoPositiveNumbers[1] = array[i + 1];
                break;
            }
        }
        if (twoPositiveNumbers[0] == 0 && twoPositiveNumbers[1] == 0){
            System.out.println ("В массиве нет двух подряд расположенных положительных чисел.");
            return;
        } else {
            System.out.println ("Числа (m, n):");
            System.out.println (Arrays.toString (twoPositiveNumbers));
        }

        int periodLength = fractionPeriod (twoPositiveNumbers[0], twoPositiveNumbers[1]);
        System.out.println ("Порядок периода дроби m/n: ");
        System.out.println (periodLength);
        }

        private static int fractionPeriod (int numerator, int denominator) {
            if(numerator % denominator == 0) {
                return 0;
            }

            int remainderOfTwo = 0;
            if(denominator  % 5 == 0){
                int remainderOfFive = 0;
                if(denominator  % 5 == 0) {
                    while (remainderOfFive == 0) {
                        denominator = denominator / 5;
                        remainderOfFive = denominator % 5;
                    }
                }
            }
            if(denominator  % 2 == 0) {
                while (remainderOfTwo == 0){
                    denominator = denominator / 2;
                    remainderOfTwo = denominator % 2;
                }
            }

            int remainder = -1;
            int powerOfTen = 1;
            while (remainder != 1) {
                if (remainder == 0){
                    return 0;
                }
                remainder = (int) (Math.pow (10, powerOfTen) % denominator);
                powerOfTen++;
            }

            return powerOfTen - 1;
        }

    }
