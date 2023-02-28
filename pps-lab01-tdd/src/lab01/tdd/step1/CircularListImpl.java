package lab01.tdd.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {


    private static final int INITIAL_POSITION = -1;
    private final List<Integer> list = new ArrayList<>();
    private int position = INITIAL_POSITION;

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
        this.position++;
        if (this.position >= list.size()) {
            this.position = 0;
        }
        return Optional.of(list.get(this.position));
    }

    @Override
    public Optional<Integer> previous() {
        this.position--;
        if (this.position < 0) {
            this.position = list.size() - 1;
        }
        return Optional.of(list.get(this.position));
    }

    @Override
    public void reset() {
        this.position = INITIAL_POSITION;
    }
}
