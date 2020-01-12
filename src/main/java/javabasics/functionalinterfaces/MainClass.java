package javabasics.functionalinterfaces;

import java.util.function.Function;
import java.util.function.Predicate;

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

    public static void main(String[] args) {
        // functionInterfaceTest();
        predicateInterfaceTest();
    }
}
