package lab01.tdd.step3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CircularListImpl implements CircularList {

    private List<Integer> previousElement = new ArrayList<>();
    private List<Integer> nextElement = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return stream().toList().size() == 0;
    }

    @Override
    public void add(int element) {
        nextElement.add(element);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        var it = stream().iterator();
        previousElement = new ArrayList<>();
        nextElement = new ArrayList<>();
        while (it.hasNext()) {
            var element = it.next();
            previousElement.add(element);
            if (predicate.test(element)) {
                it.forEachRemaining(nextElement::add);
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    private Stream<Integer> stream() {
        return Stream.of(nextElement, previousElement)
                .flatMap(Collection::stream);
    }
}
