package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

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
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testFindElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Optional.of(2), list.filteredNext(e -> e.equals(2)));
    }

    @Test
    void testFindElementCircularly() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.filteredNext(e -> e.equals(2));
        assertEquals(Optional.of(2), list.filteredNext(e -> e.equals(2)));
    }
}