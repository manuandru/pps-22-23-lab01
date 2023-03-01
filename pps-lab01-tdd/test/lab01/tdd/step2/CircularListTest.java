package lab01.tdd.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation with iterator
 */
public class CircularListTest {

    CircularList list;
    @BeforeEach
    void setUp() {
        list = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testNoEmptyIfAdd() {
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testEmptyIterator() {
        Iterator<Integer> forwardIterator = list.forwardIterator();
        assertFalse(forwardIterator.hasNext());
        Iterator<Integer> backwardIterator = list.backwardIterator();
        assertFalse(backwardIterator.hasNext());
    }

}
