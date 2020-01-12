package javabasics.functionalinterfaces;

import java.util.function.*;

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
        BiFunction interface takes two arguments as input and produce a result as output.
        An it has an andThen static method which takes a Function as input and pass the result of BiFunction into it and
        return the result of the Function apply() method. It can be used for functional streaming processing.
     */
    public static void biFunctionTest() {
        BiFunction<Integer, String, String> biFunction = (num, string) -> num + " " + string;
        biFunction.andThen(str -> str.length());
        System.out.println("Length:" + biFunction.apply(666, "means excellence"));
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

    /*
        Supplier interface serves as a factory interface.
        It takes no parameter but returns a new instance.
     */
    public static void supplierTest() {
        Supplier<Person> factory = () -> new Person("Default Name");
        System.out.println(factory.get().getName());
    }

    /*
        Consumer interface represents a function that consumes a value without returning the output.
        This can be used for printing out the result or write date to a file, or over network.
     */
    public static void consumerTest() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("This is a test string. ");
    }

    public static void main(String[] args) {
        // functionInterfaceTest();
        // predicateInterfaceTest();
        // unaryOperatorTest();
        // binaryOperatorTest(2, 3);
        // biFunctionTest();
        // supplierTest();
        consumerTest();
    }
}
