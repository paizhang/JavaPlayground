package javabasics.functionalinterfaces;

import java.util.function.Function;

public class FunctionInterfaceTest implements Function<Long, Long> {

    @Override
    public Long apply(Long value) {
        return value + 1;
    }
}
