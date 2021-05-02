package lectionHW.Functional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CombineStreams {

    public static void main(String[] args) {
        Stream<String> first = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> second = Arrays.stream(new String[]{"D", "E", "F", "G", "H"});
        Stream<String> combineStream = zip(first,second);
        System.out.println(combineStream.collect(Collectors.toList()));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        return zipper(first, second, (o1, o2) -> Stream.of(o1, o2)).flatMap(s -> s);
    }

    private static <A,B,C> Stream<C> zipper (Stream<A> A, Stream<B> B, BiFunction<A,B,C> combine){
        final Iterator<A> iteratorA = A.iterator();
        final Iterator<B> iteratorB = B.iterator();
        final Iterator<C> iteratorC = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public C next() {
                return combine.apply(iteratorA.next(),iteratorB.next());
            }

        };
        final boolean parallel = A.isParallel() || B.isParallel();
        return finStream(iteratorC,parallel);
    }

    private static <T> Stream<T> finStream(Iterator<T> iterator, boolean parallel) {
        final Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

}
