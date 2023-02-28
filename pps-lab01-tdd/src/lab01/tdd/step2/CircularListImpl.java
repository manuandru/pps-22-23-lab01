package lab01.tdd.step2;

import java.util.ArrayList;
import java.util.List;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
