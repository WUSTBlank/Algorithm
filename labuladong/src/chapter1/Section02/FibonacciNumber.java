package chapter1.Section02;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, c = 0, startI = 2;
            for (int i = startI; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        FibonacciNumber test = new FibonacciNumber();
        System.out.println(test.fib(1));
        System.out.println(test.fib(2));
        System.out.println(test.fib(6));
    }

}
