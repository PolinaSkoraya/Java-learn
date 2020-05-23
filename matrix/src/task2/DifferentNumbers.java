package task2;

import java.util.*;

public class DifferentNumbers {
    public static void searchNumber() {
        ArrayList<Integer> array = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("\nНахождение числа состоящего из различных цифр");
        System.out.println("Введите кол-во чисел: ");
        int size = input.nextInt();

        System.out.println("Введите числа массива: ");
        for (int i = 0; i < size; i++) {
            array.add(i, input.nextInt ());
        }

        for (int i = 0; i < array.size (); i++){
            ArrayList<Integer> tempArray = new ArrayList<>();
            int tempNumber = array.get (i);
            int index = 0;
            while (tempNumber != 0) {
                tempArray.add (index, tempNumber % 10);
                tempNumber = tempNumber / 10;
                index++;
            }
            index = 0;
            Set<Integer> targetSet = new HashSet<Integer> (tempArray);
            if(tempArray.size () == targetSet.size ()){
                System.out.println ("Первое число, состоящее только из различных цифр: ");
                System.out.println (array.get (i));
                return;
            }
        }

        Set<Integer> targetSet = new HashSet<Integer> (array);
        System.out.println (array.size ());
        System.out.println (targetSet.size ());
    }
}
