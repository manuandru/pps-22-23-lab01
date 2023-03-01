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

    @Test
    void testForwardCircularity() {
        list.add(1);
        list.add(2);
        Iterator<Integer> forwardIterator = list.forwardIterator();
        assertEquals(1, forwardIterator.next());
        assertEquals(2, forwardIterator.next());
        assertEquals(1, forwardIterator.next());
    }

    @Test
    void testBackwardCircularity() {
        list.add(1);
        list.add(2);
        Iterator<Integer> backwardIterator = list.backwardIterator();
        assertEquals(2, backwardIterator.next());
        assertEquals(1, backwardIterator.next());
        assertEquals(2, backwardIterator.next());
    }
}
