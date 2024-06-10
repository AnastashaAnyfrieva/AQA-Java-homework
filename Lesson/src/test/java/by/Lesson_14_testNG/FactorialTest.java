package by.Lesson_14_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import static by.Lesson_14_testNG.Factorial.calculateFactorial;

public class FactorialTest {

    @Test
    public void testCalculateFactorialForZero() {
        int result = calculateFactorial(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialForOne() {
        int result = calculateFactorial(1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialForThree() {
        int result = calculateFactorial(3);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void testCalculateFactorialForSeven() {
        int result = calculateFactorial(7);
        Assert.assertEquals(result, 5040);
    }

    @Test
    public void testCalculateFactorialForNine() {
        int result = calculateFactorial(9);
        Assert.assertEquals(result, 362880);
    }
}


