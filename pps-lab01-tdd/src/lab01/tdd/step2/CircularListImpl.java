package lab01.tdd.step2;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        List<Integer> copy = new ArrayList<>(this.list);
        return this.getIterator(copy);

    }

    @Override
    public Iterator<Integer> backwardIterator() {
        List<Integer> copy = new ArrayList<>(this.list);
        Collections.reverse(copy);
        return this.getIterator(copy);

    }

    private Iterator<Integer> getIterator(List<Integer> list) {
        return list.isEmpty() ?
                IntStream.empty().iterator()
                : Stream.generate(() -> list)
                        .flatMap(Collection::stream)
                        .iterator();
    }
}
