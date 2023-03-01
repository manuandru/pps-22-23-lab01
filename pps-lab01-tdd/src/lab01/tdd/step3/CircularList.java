package lab01.tdd.step3;

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
}
