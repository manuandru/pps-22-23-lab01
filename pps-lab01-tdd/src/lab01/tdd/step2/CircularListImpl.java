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
        if (this.isEmpty()) {
            return IntStream.empty().iterator();
        }
        return Stream.generate(() -> list)
                .flatMap(Collection::stream)
                .iterator();

    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return list.listIterator();
    }
}
