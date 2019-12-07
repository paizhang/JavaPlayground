package javabasics.datatypes;

public class PrimitiveTypes {

    public void aboutIntegers() {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int myMaxNum = 2_147_483_647;

        System.out.println("Max number is:" + max);
        System.out.println("Min number is:" + min);

        System.out.println("Busted number is:" + (max + 1));
        System.out.println("Busted number for min is:" + (min - 1));

        System.out.println("My max number:" + myMaxNum);
    }
}
