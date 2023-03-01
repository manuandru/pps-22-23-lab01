package lab01.tdd.step2;

import java.util.Iterator;

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
     * Provides a forward iterator over the list.
     * @return the forward iterator.
     */
    Iterator<Integer> forwardIterator();

    /**
     * Provides a backward iterator over the list.
     * @return the backward iterator.
     */
    Iterator<Integer> backwardIterator();
}
