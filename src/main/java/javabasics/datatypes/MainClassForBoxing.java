package javabasics.datatypes;

import java.util.ArrayList;

public class MainClassForBoxing {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // Integer.valueOf() will box primitive type value into an Integer object
            intList.add(Integer.valueOf(i));
        }

        for (int i = 0; i < intList.size(); i++) {
            // Integer.intValue() unbox Integer object into primitive type.
            System.out.println(intList.get(i).intValue());
        }

        Integer integer = 6; // This is autoboxing done by Java in compile time.

        int i = Integer.valueOf(5);  // This is auto unboxing done by Java in compile time.
    }
}
