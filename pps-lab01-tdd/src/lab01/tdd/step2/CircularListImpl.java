package lab01.tdd.step2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        return list.listIterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return list.listIterator();
    }
}
