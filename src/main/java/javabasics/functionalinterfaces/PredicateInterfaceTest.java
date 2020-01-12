package javabasics.functionalinterfaces;

import java.util.function.Predicate;

/*
The Java Predicate interface, java.util.function.Predicate, represents a simple function that takes a single value as
parameter, and returns true or false.
Note that the type of the parameter cannot be primitive type.
 */
public class PredicateInterfaceTest implements Predicate<Integer> {

    @Override
    public boolean test(Integer val) {
        return val > 0;
    }
}
