package javabasics.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamOperations {

    public static void testForEach(Stream stream) {
        stream.forEach(System.out::println);
    }

    public static void testMap(Stream stream, Function func) {
        stream.map(func).forEach(System.out::println);
    }

    public static void testFilter(Stream stream, Predicate pred) {
        stream.filter(pred).forEach(System.out::println);
    }

    public static void testLimit(Stream stream, int limit) {
        stream.limit(limit).forEach(System.out::println);
    }

    public static void testSorted(Stream stream) {
        stream.sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Tom", "Jame", "Jon", "Lady"));
        Integer[] ids = new Integer[] {1,2,3,4,5,6,7,8,9,0};
        Stream nameStream = StreamCreation.createStreamFromCollection(names);
        Stream idStream = StreamCreation.createStreamFromArray(ids);
        // testForEach(nameStream);
        // testMap(idStream, i -> (int)i * (int)i);
        // testFilter(idStream, i -> (int)i > 5);
        // testLimit(idStream, 5);
        testSorted(idStream);
    }

}
