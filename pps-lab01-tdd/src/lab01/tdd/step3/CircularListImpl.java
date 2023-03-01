package lab01.tdd.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst();
    }
}
