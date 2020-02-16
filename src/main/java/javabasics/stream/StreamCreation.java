package javabasics.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamCreation {

    public <T> Stream<T> createStreamFromCollection(Collection<T> collection) {
        return collection.stream();
    }

    public <T> Stream<T> createStreamFromArray(T[] array) {
        return Arrays.stream(array);
    }
}
