package javabasics.functionalinterfaces;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MainClass {

    public static void functionInterfaceTest() {
        /*
            We can create an object of a class which implements a Function functional interface.
         */
        Function<Long, Long> func1 = new FunctionInterfaceTest();
        System.out.println(func1.apply(5L));

        /*
            We can also create an object from a lambda function which implements a Function functional interface.
         */
        Function<Long, Long> func2 = val -> val + 1;
        System.out.println(func2.apply(5L));
    }

    public static void predicateInterfaceTest() {
        Predicate<Integer> pred1 = new PredicateInterfaceTest();
        System.out.println(pred1.test(3));

        Predicate<Integer> pred2 = val -> val > 0;
        System.out.println(pred2.test(3));
    }

    /*
        UnaryOperator interface extends Function interface. It takes an operand object as the input and usually return
        the same operand object. This is usually used in functional streaming process.
     */
    public static void unaryOperatorTest() {
        Person p = new Person("Original Name");
        UnaryOperator<Person> unaryOperator = person -> {person.setName("New Name"); return person;};
        System.out.println(unaryOperator.apply(p).getName());
    }

    /*
        BinaryOperator interface extends BiFunction interface. It takes two operands with the same type as input and
        return an object with the same type.

        It is usually used in functional streaming process.
     */
    public static void binaryOperatorTest(Integer a, Integer b) {
        BinaryOperator<Integer> binaryOperator = (val1, val2) -> val1 + val2;
        System.out.println(binaryOperator.apply(a, b));
    }

    public static void main(String[] args) {
        // functionInterfaceTest();
        // predicateInterfaceTest();
        // unaryOperatorTest();
        binaryOperatorTest(2, 3);
    }
}
