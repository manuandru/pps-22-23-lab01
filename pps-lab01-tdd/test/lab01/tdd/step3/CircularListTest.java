package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

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
    void testFindElement() {
        addElements();
        assertEquals(Optional.of(TWO), list.filteredNext(e -> e.equals(TWO)));
    }

    @Test
    void testUnsatisfiedCondition() {
        list.add(ONE);
        assertEquals(Optional.empty(), list.filteredNext(e -> e.equals(TWO)));
    }

    @Test
    void testFindElementCircularly() {
        addElements();
        list.filteredNext(e -> e.equals(TWO));
        assertEquals(Optional.of(TWO), list.filteredNext(e -> e.equals(TWO)));
    }

    private void addElements() {
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
    }

}