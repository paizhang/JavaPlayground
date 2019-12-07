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

    /*
        long primitive type occupy 64 bits. Range from -9223372036854775808 to 9223372036854775807.
     */
    public void aboutLong() {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        System.out.println("Long Max number is:" + max);
        System.out.println("Long Min number is:" + min);

        long num = 100L; // A constant number for long type should end with a upper letter 'L'.
        System.out.println("My long number is:" + num);
    }

    /*
        When operating two numbers with different primitive types, it by default follows the widening casting conversion.
        byte to short, int, long, float, or double
        short to int, long, float, or double
        char to int, long, float, or double
        int to long, float, or double
        long to float or double
        float to double

        Narrow casting conversion needs to be explicit. 
     */
    public void aboutCasting() {
        short minShort = Short.MIN_VALUE;
        byte minByte = Byte.MIN_VALUE;
        short shortNum = (short)(minByte / 2);
        byte byteNum = (byte)(minByte / 2);

    }
}
