package lab01.tdd.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation with iterator
 */
public class CircularListTest {

    public static final int ONE = 1;
    public static final int TWO = 2;
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
        addElements();
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
        addElements();
        Iterator<Integer> forwardIterator = list.forwardIterator();
        assertEquals(ONE, forwardIterator.next());
        assertEquals(TWO, forwardIterator.next());
        assertEquals(ONE, forwardIterator.next());
    }

    @Test
    void testBackwardCircularity() {
        addElements();
        Iterator<Integer> backwardIterator = list.backwardIterator();
        assertEquals(TWO, backwardIterator.next());
        assertEquals(ONE, backwardIterator.next());
        assertEquals(TWO, backwardIterator.next());
    }

    private void addElements() {
        list.add(1);
        list.add(2);
    }
}
