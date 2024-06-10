package by.Lesson_12_testng;

public class Factorial {
    public static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(4));
    }
}
