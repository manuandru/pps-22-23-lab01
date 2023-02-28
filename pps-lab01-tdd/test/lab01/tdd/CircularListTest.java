package lab01.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testMultipleAdd() {
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
        assertEquals(3, list.size());
    }

}
