package day240612.teach;

import day240612.practice.teach.MyCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @Test
    void add() {
        int actual = MyCalculator.add(1, 2);
        assertEquals(3, actual);
    }
}