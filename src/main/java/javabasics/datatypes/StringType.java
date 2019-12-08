package javabasics.datatypes;

public class StringType {

    /*
        Strings are immutable. Every time we catenate two strings, a new String is created in the heap area of the JVM memory.
     */
    public void stringCatenation() {
        String s1 = "String 1";
        String s2 = s1 + "+ String 2";
        System.out.println(s2);

        String s3 = s1 + 500; // Java automatically convert integer into String and catenate it with previous string.
        System.out.println(s3);

        String s4 = s1 + 50.5;
        System.out.println(s4);
    }

    
}
