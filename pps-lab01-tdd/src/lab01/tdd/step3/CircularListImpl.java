package lab01.tdd.step3;

import java.util.ArrayList;
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
}
