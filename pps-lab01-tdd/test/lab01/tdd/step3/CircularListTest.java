package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}