package javabasics.datatypes;

public class PrimitiveTypes {

    /*
        int primitive type occupy 32 bits. Range from -2147483648 to 2147483647.
     */
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

    /*
        A byte primitive type occupy 8 bits. Range from -128 to 127.
     */
    public void aboutByte() {
        byte min = Byte.MIN_VALUE;
        byte max = Byte.MAX_VALUE;

        System.out.println("Byte Max number is:" + max);
        System.out.println("Byte Min number is:" + min);
    }

    /*
        short primitive type occupy 16 bits. Range from -32768 to 32767. 
     */
    public void aboutShort() {
        short min = Short.MIN_VALUE;
        short max = Short.MAX_VALUE;

        System.out.println("Short Max number is:" + max);
        System.out.println("Short Min number is:" + min);
    }
}
