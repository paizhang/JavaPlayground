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
        float occupy 32 bits.
        double occupy 64 bits.

        Jave processes double faster than float.
        1. In the chip level, it is designed to process double. (TODO: Investigate that? )
        2. Internal math libraries are implemented to operate double by default. (TODO: Verify this.)

        If double type still cannot meet the precision requirement, Java has a BigDecimal class for overcoming this problem.
     */
    public void aboutFloatAndDouble() {
        float floatMin = Float.MIN_VALUE;
        float floatMax = Float.MAX_VALUE;
        System.out.println("Float Max number is:" + floatMin);
        System.out.println("Float Min number is:" + floatMax);

        double doubleMin = Double.MIN_VALUE;
        double doubleMax = Double.MAX_VALUE;
        System.out.println("Double Max number is:" + doubleMin);
        System.out.println("Double Min number is:" + doubleMax);

        float num1 = 5f;  // Constant ending with 'f' indicates a float constant number.
        double num2 = 10d; // Constant ending with 'd' indicates a double constant number.
        System.out.println("Float number is:" + num1);
        System.out.println("Double number is:" + num2);

        float num3 = (float) 5.25;  // By default, all float point number constants are casted into double. So we need to explicitly convert it into float.
    }

    /*
        char primitive type occupies 16 bits. That is because it supports unicode.
        TODO: You can dive deep to learn more about different unicode types.
     */
    public void aboutChar() {
        char myChar = 'D';
        char myUnicodeChar = '\u0040';

        System.out.println(myChar);
        System.out.println(myUnicodeChar);
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

        byte num1 = 8;
        short num2 = 80;
        int num3 = 800;
        long sum = 50000 * (num1 + num2 + num3);

        System.out.println("Sum is:" + sum);
    }
}
