package by.Lesson_14_junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void testCalculateFactorialForZero() {
        int result = Factorial.calculateFactorial(0);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testCalculateFactorialForOne() {
        int result = Factorial.calculateFactorial(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testCalculateFactorialForThree() {
        int result = Factorial.calculateFactorial(3);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testCalculateFactorialForSeven() {
        int result = Factorial.calculateFactorial(8);
        Assertions.assertEquals(40320, result);
    }

    @Test
    void testCalculateFactorialForNine() {
        int result = Factorial.calculateFactorial(9);
        Assertions.assertEquals(362880, result);
    }
}