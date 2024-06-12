package day240612.practice.teach;

public class MyCalculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int secretAdd(int a, int b) {
        // 假设 5 是密钥
        return add(a, b) + 5;
    }
}
