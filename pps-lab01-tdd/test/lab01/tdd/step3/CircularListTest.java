package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation with filter
 */
class CircularListTest {

    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
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
        assertEquals(Optional.of(TWO), list.filteredNext(TWO::equals));
    }

    @Test
    void testUnsatisfiedCondition() {
        list.add(ONE);
        assertEquals(Optional.empty(), list.filteredNext(TWO::equals));
    }

    @Test
    void testFindElementCircularly() {
        addElements();
        list.filteredNext(TWO::equals);
        assertEquals(Optional.of(TWO), list.filteredNext(TWO::equals));
    }

    @Test
    void testGetCorrectNext() {
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
        list.add(TWO);
        list.filteredNext(TWO::equals);
        Predicate<Integer> predicateToGetThree = e -> e.equals(THREE) || e.equals(TWO);
        assertEquals(Optional.of(THREE), list.filteredNext(predicateToGetThree));
    }

    private void addElements() {
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
    }

}