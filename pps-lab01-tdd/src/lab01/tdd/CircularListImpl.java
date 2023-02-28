package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int counter = -1;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        this.counter++;
        return Optional.of(list.get(this.counter));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.counter < 0) {
            this.counter = list.size() - 1;
        }
        return Optional.of(list.get(this.counter));
    }

    @Override
    public void reset() {

    }
}
