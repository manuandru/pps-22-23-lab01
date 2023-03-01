package lab01.tdd.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private CircularList list;

    @BeforeEach
    void setUp() {
        list = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testNotEmptyIfAdd() {
        list.add(ONE);
        assertFalse(list.isEmpty());
    }

    @Test
    void testIteratorOnEmptyList() {
        assertEquals(Optional.empty(), list.next());
        assertEquals(Optional.empty(), list.previous());
    }

    @Test
    void testMultipleAdd() {
        addElements();
        assertEquals(3, list.size());
    }

    @Test
    void testForward() {
        list.add(ONE);
        assertEquals(Optional.of(ONE), list.next());
    }

    @Test
    void testBackward() {
        list.add(ONE);
        assertEquals(Optional.of(ONE), list.previous());
    }

    @Test
    void testForwardCircularity() {
        addElements();
        list.next();
        list.next();
        list.next();
        assertEquals(Optional.of(ONE), list.next());
    }

    @Test
    void testBackwardCircularity() {
        addElements();
        list.previous();
        list.previous();
        list.previous();
        assertEquals(Optional.of(THREE), list.previous());
    }

    @Test
    void testMixedForwardAndBackward() {
        addElements();
        list.next();
        list.next();
        list.next();
        assertEquals(Optional.of(TWO), list.previous());
    }

    @Test
    void testResetList() {
        addElements();
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(ONE), list.next());
    }

    private void addElements() {
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
    }

}
