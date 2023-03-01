package lab01.tdd.step3;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularList {

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(int element);

    /**
     * Return the next element that satisfies the predicate
     * @param predicate to be satisfied
     * @return the next element that satisfies the predicate, otherwise empty
     */
    Optional<Integer> filteredNext(Predicate<Integer> predicate);
}
