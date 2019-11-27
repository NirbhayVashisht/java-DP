//program showing time taken in solving fibonacci problem with and without dp

public class Fibonacci {
    public static long start;
    public static long end;

    public static void startTime() {
        start = System.currentTimeMillis();
    }

    public static long totalTime() {
        end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {
        int n = 45;
        int[] storage = new int[n + 1];

        //Normal fibonacci method
        startTime();
        System.out.println("Without DP : " + fibonacciNormal(n) + ", time took : " + totalTime() + "ms");

        //fibonacci method using DP
        startTime();
        System.out.println("With DP : " + fibonacciDP(n, storage) + ", time took : " + totalTime() + "ms");

        //fibonacci using iterative storage method
        startTime();
        System.out.println("With Iterative Storage : " + fibonacciIterativeStorage(n) + ", time took : " + totalTime() + "ms");

    }

    public static int fibonacciNormal(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f1 = fibonacciNormal(n - 1);
        int f2 = fibonacciNormal(n - 2);
        int f = f1 + f2;
        return f;
    }

    public static int fibonacciDP(int n, int[] storage) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (storage[n] != 0) {
            return storage[n];
        }

        int f1 = fibonacciDP(n - 1, storage);
        int f2 = fibonacciDP(n - 2, storage);
        int f = f1 + f2;
        storage[n] = f; //storing value before returning
        return f;
    }

    public static int fibonacciIterativeStorage(int n) {
        int[] storage = new int[n + 1];

        storage[0] = 0;
        storage[1] = 1;

        for (int i = 2; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2];
        }

        return storage[n];
    }
}
