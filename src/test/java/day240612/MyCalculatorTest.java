package day240612;

import org.junit.jupiter.api.Test;
import day240612.practice.me.MyCalculator;
import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @Test
    void add() {
        int actual = MyCalculator.add(1, 2);
        assertEquals(3, actual);
    }

    @Test
    void testSecretAddWithAssertTrue() {
        assertTrue(8 == MyCalculator.secretAdd(1, 2));
    }

    @Test
    void testSecretAddWithAssertEquals() {
        assertEquals(8, MyCalculator.secretAdd(1, 2));
    }
}