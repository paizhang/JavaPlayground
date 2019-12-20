package javabasics.arrays;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        // Array creation and initialization.
        // Default values set to an int array is 0. Default values for boolean type array is set to false.
        // Default values set to String or other objects are set to null.
        int[] arr1 = new int[10];
        int[] arr2 = {1, 2, 3, 4, 5};

        // Array access.
        arr1[2] = 4;
        arr2[4] = 5;

        // Array iteration.
        System.out.println("arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("arr2: ");
        for (int i : arr2) {
            System.out.println(i);
        }

        //Arrays operations.
        int[] arr3 = Arrays.copyOf(arr2, arr2.length);
        // Note that default toString() will output the address of the array, instead of items. Because arrays is reference type variable.
        System.out.println(arr3.toString());
        // Instead, we should use Arrays.toString() to print items
        System.out.println(Arrays.toString(arr3));
    }
}
