package lab01.tdd.step3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CircularListImpl implements CircularList {

    private List<Integer> previousElements = new ArrayList<>();
    private List<Integer> nextElements = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return stream().toList().size() == 0;
    }

    @Override
    public void add(int element) {
        nextElements.add(element);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        var it = stream().iterator();
        previousElements = new ArrayList<>();
        nextElements = new ArrayList<>();
        while (it.hasNext()) {
            var element = it.next();
            previousElements.add(element);
            if (predicate.test(element)) {
                it.forEachRemaining(nextElements::add);
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    private Stream<Integer> stream() {
        return Stream.of(nextElements, previousElements)
                .flatMap(Collection::stream);
    }
}
